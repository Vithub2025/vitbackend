package com.vitg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitg.dto.EmployeeDTO;
import com.vitg.dto.OTPResponseDTO;
import com.vitg.dto.PhoneVerificationDTO;
import com.vitg.dto.RoleDTO;
import com.vitg.dto.UserDTO;
import com.vitg.entity.PhoneVerification;
import com.vitg.entity.Role;
import com.vitg.entity.User;
import com.vitg.exception.AwsSnsClientException;
import com.vitg.exception.LockedException;
import com.vitg.exception.OTPException;
import com.vitg.exception.RecordNotFoundException;
import com.vitg.exception.ResourceAlreadyExistsException;
import com.vitg.repository.RoleRepository;
import com.vitg.repository.UserRepository;
import com.vitg.service.EmployeeService;
import com.vitg.service.OTPService;
import com.vitg.service.UserService;
import com.vitg.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired 
	private OTPService otpService;

	@GetMapping("login/sendOtp")
	public ResponseEntity<OTPResponseDTO> sendOtp(@RequestParam String phoneNumber) throws LockedException{
		if (!userRepository.existsByPhoneNumber(phoneNumber)) {
			throw new RecordNotFoundException("Account with  : " + phoneNumber + " Not Exists : Please Register");
		}

		User user=userRepository.findByPhoneNumber(phoneNumber);

		if (user !=null && !user.isAccountNonLocked()) {
			if (!userService.unlockWhenTimeExpired(user)) {
				throw new LockedException("Your account has been Locked. Please try to login after Sometime.");
			}
			else {

				int otp = otpService.generateOTP();
				String verificationRef = otpService.generateVerificationRef();
				otpService.savePhoneVerification(new PhoneVerification(phoneNumber, verificationRef, String.valueOf(otp), 0));
				otpService.sendOTP(String.valueOf(otp),phoneNumber);

				OTPResponseDTO otpResponseDTO=new OTPResponseDTO();
				otpResponseDTO.setPhoneNumber(phoneNumber);
				otpResponseDTO.setVerificationRef(verificationRef);
				otpResponseDTO.setStatusMessage("SUCCESS");
				return new ResponseEntity<>(otpResponseDTO, HttpStatus.OK);
			}
		}
		else {

			int otp = otpService.generateOTP();
			String verificationRef = otpService.generateVerificationRef();

			otpService.savePhoneVerification(new PhoneVerification(phoneNumber, verificationRef, String.valueOf(otp), 0));
			otpService.sendOTP(String.valueOf(otp),phoneNumber);

			OTPResponseDTO otpResponseDTO=new OTPResponseDTO();
			otpResponseDTO.setPhoneNumber(phoneNumber);
			otpResponseDTO.setVerificationRef(verificationRef);
			otpResponseDTO.setStatusMessage("SUCCESS");
			return new ResponseEntity<>(otpResponseDTO, HttpStatus.OK);
		}
	}
	
	@PostMapping("login/verifyOtp")
	public ResponseEntity<UserDTO> verifyOtp(@RequestBody PhoneVerificationDTO phoneVerificationDTO ) {

		boolean verified =otpService.verifyOtp(phoneVerificationDTO);

		if(verified)  {
			if(userRepository.existsByPhoneNumber(phoneVerificationDTO.getPhoneNumber())){
				User user = userRepository.findByPhoneNumber(phoneVerificationDTO.getPhoneNumber());
				//UserDTO userDTO = authenticateUser(user);
				Role role = user.getRole();

//				if(role.getRoleName().equals("TRAINER")) {
//					user.setFailedAttempt(0);
//					userRepository.save(user);
//					Trainer trainer=trainerRepository.findByPhoneNumber(phoneVerificationDTO.getPhoneNumber());
//					TrainerDTO trainerDTOResponse=modelMapper.map(trainer, TrainerDTO.class);
//
//					userDTO.setTrainerDTO(trainerDTOResponse);
//					return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//				}
//
//				if(role.getRoleName().equals("STUDENT")) {
//					user.setFailedAttempt(0);
//					userRepository.save(user);
//					Student student=studentRepository.findByPhoneNumber(phoneVerificationDTO.getPhoneNumber());
//					StudentDTO studentDTOResponse=modelMapper.map(student, StudentDTO.class);
//					System.out.println(studentDTOResponse);
//
//					userDTO.setStudentDTO(studentDTOResponse);
//					return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//
//				}
//				if(role.getRoleName().equals("ADMIN")||role.getRoleName().equals("MANAGER") ||
//						role.getRoleName().equals("ACCOUNTANT")|| role.getRoleName().equals("ORGANIZER") ||
//						role.getRoleName().equals("GUEST") || role.getRoleName().equals("SUPPORT_ENGINEER")) {
//					System.out.println("test");
//					user.setFailedAttempt(0);
//					userRepository.save(user);
//					Staff staff = staffRepository.findByPhoneNumber(phoneVerificationDTO.getPhoneNumber());
//					StaffDTO staffDTOResponse = modelMapper.map(staff, StaffDTO.class);
//
//					userDTO.setVitgStaffDTO(staffDTOResponse);
//					return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//
//				}
			}	
			else {

				User user = new User();
				user.setPhoneNumber(phoneVerificationDTO.getPhoneNumber());
				User savedUser = userRepository.save(user);
				UserDTO userDTO= new UserDTO();
				userDTO.setId(savedUser.getId());
				userDTO.setPhoneNumber(savedUser.getPhoneNumber());

				return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
			}																																																							

		}else {
			User user=userRepository.findByPhoneNumber(phoneVerificationDTO.getPhoneNumber());

			if (user != null && user.isAccountNonLocked()) {
				if (user.getFailedAttempt() < userServiceImpl.MAX_FAILED_ATTEMPTS - 1) {
					int failledAttemptsCount=  userService.increaseFailedAttempts(user);
					throw new OTPException("Invalid OTP  : Failed attempts : "+ failledAttemptsCount);
				} else {
					userService.lock(user);
					throw new LockedException("Your account has been locked due to 3 failed attempts."
							+ " It will be unlocked after 2 minutes.");
				}
			}
		}
		return null;
	}
	
	@GetMapping("register/vitg/employee/sendOtp") 
	public ResponseEntity<OTPResponseDTO> sendOtpForVitgStaffRegistration(@RequestParam String phoneNumber) { 

		if (userRepository.existsByPhoneNumber(phoneNumber)) { 
			throw new ResourceAlreadyExistsException("account with  : " + phoneNumber + " already exists"); 
		}
		else {

			int otp = otpService.generateOTP();
			String verificationRef = otpService.generateVerificationRef();
			otpService.savePhoneVerification(new PhoneVerification(phoneNumber, verificationRef, String.valueOf(otp), 0));
			try {
				otpService.sendOTP(String.valueOf(otp),phoneNumber);

			}catch (AwsSnsClientException e)
			{ 
				throw new AwsSnsClientException("Not able to send SMS to : " + phoneNumber ); 
			}

			OTPResponseDTO otpResponseDTO = new OTPResponseDTO();
			otpResponseDTO.setPhoneNumber(phoneNumber);
			otpResponseDTO.setVerificationRef(verificationRef);
			otpResponseDTO.setStatusMessage("SUCCESS");
			return new ResponseEntity<>(otpResponseDTO, HttpStatus.OK);

		}
	}

	//Admin will verify OTP to register Staff

	@PostMapping("register/vitg/employee/verifyOtp") 
	public ResponseEntity<EmployeeDTO> validateStaffOtp(@RequestBody PhoneVerificationDTO phoneVerificationDTO ) {

		boolean verified = otpService.verifyOtp(phoneVerificationDTO);

		if(verified) {

			User user = new User();
			user.setPhoneNumber(phoneVerificationDTO.getPhoneNumber());
			user.setLockTime(null);
			user.setAccountNonLocked(true);
			Role role = roleRepository.findByroleName("GUEST");
			user.setRole(role);
			userService.saveUser(user);

			UserDTO userDTO = userService.saveUser(user);

			EmployeeDTO employeeDTO = new EmployeeDTO(); 
			employeeDTO.setId(userDTO.getId());
			employeeDTO.setMobileNumber(userDTO.getPhoneNumber());
			//employeeDTO.setRegistrationStatus(false);

			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(role.getId());
			roleDTO.setRoleName(role.getRoleName());

			employeeDTO.setRole(roleDTO);
			EmployeeDTO employeeDTOResponse = employeeService.addEmployee(employeeDTO);

			return new ResponseEntity<>(employeeDTOResponse, HttpStatus.CREATED);
		}
		else{
			throw new OTPException("Invalid OTP");
		}

	}


}

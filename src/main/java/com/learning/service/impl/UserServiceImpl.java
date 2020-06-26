package com.learning.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.learning.dao.UserRepository;
import com.learning.dto.UserDTO;
import com.learning.model.User;
import com.learning.model.base.Demande;
import com.learning.model.base.PartialList;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = convertDTOtoModel(userDTO);
		user = userRepository.saveAndFlush(user);
		return convertModelToDTO(user);
	}

	@Override
	public UserDTO findById(long idOut) {
		Optional<User> optional = userRepository.findById(idOut);

		if (optional.isPresent()) {
			User user = optional.get();
			return convertModelToDTO(user);
		}
		return null;
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public PartialList<UserDTO> findByCriteres(Demande<UserDTO> demande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User convertDTOtoModel(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setIsOffline(false);

		return user;
	}

	@Override
	public UserDTO convertModelToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setCreatedAt(user.getCreatedAt());
		userDTO.setUpdatedAt(user.getUpdatedAt());

		return userDTO;
	}

	@Override
	public PartialList<UserDTO> convertToListDTO(PartialList<User> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> convertEntitiesToDtos(List<User> list) {
		List<UserDTO> users = new ArrayList<UserDTO>();

		for (User user : list) {
			users.add(convertModelToDTO(user));
		}
		return users;
	}

	@Override
	public List<User> convertDtosToEntities(List<UserDTO> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> findAllProfessor() {
		// a modifier par finndAll By role professor
		List<User> users = userRepository.findAll();
		return convertEntitiesToDtos(users);
	}

	@Override
	public User convertDTOtoModelWithOutRelation(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setIsOffline(false);

		return user;
	}

	@Override
	public UserDTO convertModelToDTOWithOutRelation(User user) {
	
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setCreatedAt(user.getCreatedAt());
		userDTO.setUpdatedAt(user.getUpdatedAt());

		return userDTO;
	}

	@Override
	public List<UserDTO> convertEntitiesToDtosWithOutRelation(List<User> list) {
		List<UserDTO> users = new ArrayList<UserDTO>();

		for (User user : list) {
			users.add(convertModelToDTOWithOutRelation(user));
		}
		return users;
	}

	@Override
	public List<User> convertDtosToEntitiesWithOutRelation(List<UserDTO> list) {
		List<User> users = new ArrayList<User>();

		for (UserDTO user : list) {
			users.add(convertDTOtoModel(user));
		}
		return users;
	}

	@Override
	public List<UserDTO> findByLevelAndBranch(Long idLevel, Long idBranch) {
		List<User> list=userRepository.findByLevelAndBranch(idLevel, idBranch);
		return convertEntitiesToDtosWithOutRelation(list);
	}

	public User findUser(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public User findUserByToken(String token) {
		return userRepository.findByToken(token);
	}

	@Override
	public User findUserByOldToken(String oldToken) {
		return userRepository.findByOldToken(oldToken);
	}

	@Override
	public UserDetails getUserPrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userPrinciPal;
		if (principal instanceof UserDetails) {
			userPrinciPal = ((UserDetails) principal);
			return userPrinciPal;
		}
		return null;
	}

	
	@Override
	public void logout(String username) {
		User user = findUser(username);
		user.setIsOnline(false);
		user.setIsOffline(true);
		userRepository.save(user);
	}

	@Override
	public User addTokenToUser(String username, String token, String oldToken) {
		User user = findUser(username);
		user.setToken(token);
		user.setOldToken(user.getOldToken() == null ? token : oldToken);
		user.setTokenDateCreation(LocalDateTime.now());
		user.setIsOnline(true);
		user.setIsOffline(false);
		userRepository.saveAndFlush(user);
		return user;
	}



}

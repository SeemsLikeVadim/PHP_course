package com.example.php_course2.service;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.model.User;
import com.example.php_course2.repository.DeputyRepository;
import com.example.php_course2.repository.UserRepository;
import com.example.php_course2.web.dto.DeputyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeputyServiceImpl implements DeputyService{
    final
    DeputyRepository deputyRepository;
    final
    UserRepository userRepository;

    public DeputyServiceImpl(DeputyRepository deputyRepository, UserRepository userRepository) {
        this.deputyRepository = deputyRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Deputy save(DeputyDto registrationDto) {
        Deputy deputy = new Deputy(
                registrationDto.getName(),
                registrationDto.getParty()
        );
        return deputyRepository.save(deputy);
    }
    @Override
    public List<Deputy> getAll() {
        return deputyRepository.findAll();
    }

    @Override
    public void deleteAll() {
        deputyRepository.deleteAll();
    }

    @Override
    public void deleteDeputyById(long id) {
        deputyRepository.deleteById(id);
    }

    @Override
    public Deputy findById(long id) {
        return deputyRepository.findById(id).get();
    }

    @Override
    public Deputy updateDeputy(DeputyDto deputyDto) {
        Deputy deputy = findById(deputyDto.getId());
        deputy.setName(deputyDto.getName());
        deputy.setParty(deputyDto.getParty());
        return deputyRepository.save(deputy);
    }
    @Override
    public void plusVote(long id, String email){
        User user = userRepository.findByEmail(email);
        if(!user.getVoted()) {
            Deputy deputy = findById(id);
            int votes = deputy.getVotes();
            deputy.setVotes(votes + 1);
            user.setVoted(true);
            deputyRepository.save(deputy);
            user.setDeputy(deputy);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> whoVote(long id) {
        Deputy deputy = findById(id);
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getDeputy() != null)
                .filter(user -> user.getDeputy().equals(deputy))
                .collect(Collectors.toList());
    }
}

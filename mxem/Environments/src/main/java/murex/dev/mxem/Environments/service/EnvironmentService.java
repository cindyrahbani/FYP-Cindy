package murex.dev.mxem.Environments.service;

import murex.dev.mxem.Environments.exception.EnvironmentNotFoundException;
import murex.dev.mxem.Environments.model.Environment;
import murex.dev.mxem.Environments.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentService implements IEnvironmentService {

    @Autowired
    EnvironmentRepository environmentRepository;

    @Autowired(required = true)
    AuthorizationService authorizationService;

    public Environment add(Environment environment){
        environmentRepository.save(environment);
        return environment;
    }


    public Environment findById(String id){
        Environment env = environmentRepository.findById(id).get();
        return env;
    }

    public List<Environment> findByName(String id){
        List<Environment> env = environmentRepository.findByName(id);
        return env;
    }


    public List<Environment> findAll(){
        return environmentRepository.findAll();
    }

    public Environment updateNameOfEnvironment(String name, String newName, String token) throws EnvironmentNotFoundException {
        Optional<Environment> env = environmentRepository.findById(name);
        if(env.get()==null){
            throw new EnvironmentNotFoundException();
        }
         Environment environment= env.get();
        environment.setName(newName);
        environment.setModifiedBy(authorizationService.getUsernameFromToken(token));
        environment.setModifiedOn(new Date());

        environmentRepository.save(environment);
        return environment;
    }

    public void deleteEnvironmentById(String envId, String token){
        Environment env = findById(envId);
        env.setIsDeleted(true);
        env.setModifiedBy(authorizationService.getUsernameFromToken(token));
        env.setModifiedOn(new Date());
        environmentRepository.save(env);
    }


    public List<Environment> findByProjectId(String id){
        return environmentRepository.findByProjectId(id);
    }
}

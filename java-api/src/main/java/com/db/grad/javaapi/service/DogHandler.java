package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public DogsRepository getItsDogRepo() {
        return itsDogRepo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String DogName) {
        List<Dog> DogList = itsDogRepo.findByName(new Dog(DogName));
        if(DogList == null){
            return null;
        } else if(DogList.size() == 1){
            return DogList.get(0);
        }
        return null;
    }

    public Dog getDogById(long id) {
        return  itsDogRepo.findById(id);
    }

    public boolean removeDog(long id) {
        return itsDogRepo.delete(itsDogRepo.findById(id));
    }
}

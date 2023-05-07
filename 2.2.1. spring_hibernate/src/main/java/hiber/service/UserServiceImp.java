package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImp implements UserService {

   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.add(user);
   }


   //@Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getUserCar(String model, int series) {
      return userDao.getUserCar(model, series);
   }


}

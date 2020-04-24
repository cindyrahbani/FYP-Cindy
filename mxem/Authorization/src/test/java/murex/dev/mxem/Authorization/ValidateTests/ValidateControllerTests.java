//package murex.dev.mxem.Authorization.ValidateTests;
//
//import murex.dev.mxem.Emvironments.controller.UserController;
//import murex.dev.mxem.Emvironments.model.Role;
//import murex.dev.mxem.Emvironments.model.User;
//import murex.dev.mxem.Emvironments.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import javax.ws.rs.core.Application;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest(classes = Application.class)
//@ExtendWith(MockitoExtension.class)
//public class ValidateControllerTests {
////    @InjectMocks
////    UserController userController;
////
////    @Mock
////    UserService userService;
////
////    @Test
////    public void testFindAll()
////    {
////        Set<Role> roleSet = null;
////        // given
////        User user1 = new User((long) 75093209,"cindy",roleSet,true, new Date(),"cindy", new Date(),"cindy");
////        User user2 = new User((long) 753209,"fanie", roleSet,true, new Date(),"fanie", new Date(),"fanie");
////        User user3 = new User((long) 9209,"lea",roleSet,true, new Date(),"lea", new Date(),"lea");
////
////        ArrayList<User> users = new ArrayList<User>();
////        users.add(user1);
////        users.add(user2);
////        users.add(user3);
////
////        when(userService.findAllUsers()).thenReturn(users);
////        // when
////        ResponseEntity<List<User>> users1 = userController.getAllUsers();
////        // then
////        assertThat(users1.getStatusCodeValue()).isEqualTo(200);
////    }
//}
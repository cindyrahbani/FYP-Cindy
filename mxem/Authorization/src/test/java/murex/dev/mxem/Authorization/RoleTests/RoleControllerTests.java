package murex.dev.mxem.Authorization.RoleTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class RoleControllerTests {
//    @InjectMocks
//    RoleController rolecontroller;
//
//    @Mock
//    RoleService roleService;
//
//    @Test
//    public void testFindAll()
//    {
//        // given
//        Role role1 = new Role((long) 123456, "Cindy", false, new Date(),"Cindy",new Date(),"Cindy");
//        Role role2 = new Role((long) 456354, "kiki", false, new Date(),"kiki",new Date(),"kiki");
//        Role role3 = new Role((long) 987609, "fanie", false, new Date(),"fanie",new Date(),"fanie");
//
//
//        ArrayList<Role> roles = new ArrayList<Role>();
//        roles.add(role1);
//        roles.add(role2);
//        roles.add(role3);
//
//        when(roleService.findAllRoles()).thenReturn(roles);
//        // when
//        ResponseEntity<List<Role>> roles1 = rolecontroller.getAllRoles();
//        // then
//        assertThat(roles1.getStatusCodeValue()).isEqualTo(200);
//    }
}
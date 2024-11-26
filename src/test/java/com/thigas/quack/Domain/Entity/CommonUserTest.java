//package com.thigas.quack.Domain.Entity;
//
//import com.thigas.quack.Domain.Utils.Status;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.OffsetDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class CommonUserTest {
//    CommonUser commonUser;
//
//    @BeforeEach
//    public void setUp() {
//        commonUser = new CommonUser(
//                1,
//                "Henrique Souza",
//                "henriquesouza",
//                "5599999999999",
//                "henrique@example.com",
//                "minhasenha123",
//                "12345678900",
//                LocalDate.parse("1995-08-15"),
//                OffsetDateTime.parse("2024-11-03T00:00:00+00:00"),
//                "/images/user1.png",
//                Status.ACTIVE
//        );
//    }
//
//    @Test
//    public void passwordIsValid() {
//        assertTrue(commonUser.passwordIsValid());
//    }
//}

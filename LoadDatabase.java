package dev.kritchalach.handytools;

import org.slf4j.Logger;
//จำเป็นต้องมีการ import library นี่ด้วย
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//ถ้าจะใช้ bean จำเป็นต้อง @configuration
@Configuration
public class LoadDatabase {


    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  //class เราจะใช้ log 
  //เราสร้าง bean เพราะเทสครั้งเดียว
  //bean จะไปอยู่ภายใต้ application context นั้น สิ่งที่เราต้องการคือ storage
    @Bean
    CommandLineRunner initDatabase(StorageRepository repository) {
      //มีการตั้งชื่อ storage ว่าชื่อ repository มีการสั่งในรูปแบบของ  bean
      
        return args -> {
          //จับ function ใส่ได้เลย เรียดว่า fluent style 
          //
            log.info("loading "+repository.save(new Storage("hammer", "kt", "outside storage", false, null)));
            log.info("loading "+repository.save(new Storage("screwdriver", "kt", "toolbox 2nd floor", false, null)));
            log.info("loading"+repository.save(new Storage("paint brush","kt","paint cabinet",false,null)));
          //เมื่อทำการรันแล้ว ทดสอบดูว่า ข้อมูบที่ key เข้าไปอยู่ใน db รึเปล่า
          //ควรจะมี data ที่ใส่เข้าไป โดยมีการเรียง id  0,1,2,3 
          //ตอนนี้มี connection ไปที่ db ผ่าน jda แล้ว
          //MVC model, x, control
          //db connector web ตัวต่อมาคือ web server ยังไม่มีอservice เลย ต้องสร้าง class ใหม่ คือ controller
        };
      
    }
}

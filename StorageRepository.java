package dev.kritchalach.handytools;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
//ทำไมต้องมี storage repository คือเราพยยจะใช้ jpa กับ db ให้มันทำงานได้ตามต้องการ
  //ทุกครั้งที่รัน jdbcจะถูก generate ขึ้นมาใหม่
  //ลอง copy jdbc แล้วใส่เข้าไปใน h2 db จะเห็นว่ามีการสร้าง storage ขึ้นมาแล้ว แต่ภายนยังว่างเปล่า
  //สามารถใช้ jpa repository ได้แล้ว
  //เราทำการ autowired jpa ต่อกับ db primary key ควรจะเป็นอะไร
  //การทดสอบควรมี data in db สร้างไฟล์ขึ้นมาใหม่เป็นคลาสเพื่อเอา data load เข้าไปใน db เป็น configuration เลยมีการใช้ bean 
}

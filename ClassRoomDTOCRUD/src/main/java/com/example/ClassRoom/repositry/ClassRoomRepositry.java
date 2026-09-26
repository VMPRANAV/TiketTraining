package com.example.ClassRoom.repositry;

import com.example.ClassRoom.dto.ClassRoomResponse;
import com.example.ClassRoom.dto.StudentResponse;
import com.example.ClassRoom.entity.ClassRoom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClassRoomRepositry extends JpaRepository<ClassRoom,Integer> {
  @Query("select c from ClassRoom  c where lower(c.studentName)=lower( :studentName)")
ClassRoom findByStudentNameIgnoreCase( @Param("studentName")  String studentName);

  @Query("select c from ClassRoom  c where c.studentName= :studentName")
ClassRoom findByStudentName( @Param("studentName") String studentName);
    @Query(" select new com.example.ClassRoom.dto.StudentResponse( c.rollNo,c.studentName,c.dateOfBirth,c.className,c.bloodGroup ) from ClassRoom c  where c.bloodGroup in (select c2.bloodGroup  from ClassRoom  c2  group by  c2.bloodGroup having  count(c2)=1)")
    List<StudentResponse> findStudentByUniqBloodGroup();
}

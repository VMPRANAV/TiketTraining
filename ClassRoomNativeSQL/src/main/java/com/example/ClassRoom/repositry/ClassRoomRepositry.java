package com.example.ClassRoom.repositry;

import com.example.ClassRoom.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRoomRepositry extends JpaRepository<ClassRoom, Integer> {

}

package com.example.ClassRoom.repositry;

import com.example.ClassRoom.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClassRoomRepositry extends JpaRepository<ClassRoom,Integer> {

}

package com.example.ClassRoom.client;

import com.example.ClassRoom.entity.ClassRoom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ClassRomSqlClient",url="http://localhost:8081")
public interface ClassRoomClient {
@GetMapping("/getDetails/{rollNo}")
   ClassRoom getStudentDetails(@PathVariable("rollNo") int rollNo);
}




package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z-FominykhVJ on 08.08.2018.
 */
public interface MessageRepo extends CrudRepository<Message, Long>{
}

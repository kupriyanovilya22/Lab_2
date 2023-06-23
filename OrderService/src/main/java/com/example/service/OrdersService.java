package com.example.service;

import com.example.model.OrderDTO;
import com.example.model.OrderEntity;
import com.example.model.ResponseDTO;
import com.example.repository.OrderRepo;
import com.example.repository.UserModuleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
        //@Component
@Service
public class OrdersService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserModuleApi userModuleApi;



    public ResponseDTO addOrder(OrderDTO orderDTO) {
            ResponseDTO responseDTO =  new ResponseDTO();
            OrderEntity orderEntity =  new OrderEntity();
            orderEntity.setId(orderDTO.getId());
            orderEntity.setName(orderDTO.getName());
            orderEntity.setQuantity(orderDTO.getQuantity());
            orderEntity.setTitles(orderDTO.getTitles());
            orderRepo.save(orderEntity);
            return responseDTO;
        }

//        public ResponseDTO buyProduct(OrderDTO orderDTO){
//        ResponseDTO responseDTO =  new ResponseDTO();
//            return responseDTO;
//        }
    }

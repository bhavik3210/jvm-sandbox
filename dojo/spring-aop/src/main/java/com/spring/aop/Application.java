package com.spring.aop;

import com.spring.aop.dao.PassengerDao;
import com.spring.aop.model.Flight;
import com.spring.aop.model.Passenger;
import com.spring.aop.model.Ticket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Flight flight = context.getBean("flight", Flight.class);

		flight.print();
		System.out.println(flight.getId());
		flight.setId("AA5678");
		System.out.println(flight.getId());

		for (Passenger passenger : flight.getPassengers()) {
//			System.out.println(passenger.getName());
			passenger.print();
		}


		Ticket ticket = (Ticket) context.getBean("ticket");
		System.out.println(ticket);
		ticket.setNumber("09234234234f");
		System.out.println(ticket);

		PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
		passengerDao.getPassenger(1);
		passengerDao.getPassenger(1);
	}

}

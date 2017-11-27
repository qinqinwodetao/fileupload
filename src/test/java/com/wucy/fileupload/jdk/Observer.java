package com.wucy.fileupload.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

interface Observer {

	void notify(String msg);

}

class A implements Observer {

	private static Logger logger = LoggerFactory.getLogger(A.class);

	@Override
	public void notify(String msg) {
		logger.info(msg);
	}
}

class B implements Observer {

	private static Logger logger = LoggerFactory.getLogger(B.class);

	@Override
	public void notify(String msg) {
		logger.info(msg);
	}
}

interface Subject {
	void registerObserver(Observer observer);
	void notifyObservers(String msg);
}


class Feed implements Subject {

	private final ArrayList<Observer> observers = new ArrayList<>();

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyObservers(String msg) {
		observers.forEach(observer -> observer.notify(msg));
	}


	public static void main(String[] args) {

		Feed feed = new Feed();

		feed.registerObserver(new A());
		feed.registerObserver(new B());

		feed.notifyObservers("xxx");


	}
}


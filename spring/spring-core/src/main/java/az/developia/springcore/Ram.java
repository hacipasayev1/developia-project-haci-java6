package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Ram {
private int id;
private String model;
private int speed;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public Ram() {
	id=5;
	speed=444;
	model="leneovo";
}
@Override
public String toString() {
	return "Ram [id=" + id + ", model=" + model + ", speed=" + speed + "]";
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
}

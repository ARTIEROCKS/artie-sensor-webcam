package artie.sensor.webcam.services;
package artie.sensor.webcam.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.services.ArtieClientSensorImpl;


@Service
public class SampleService extends ArtieClientSensorImpl {
	
	/**
	 * About the sensor information
	 */
	private void sensorInformation(){
		this.name = "Sample Sensor";
		this.version = "0.0.1";
		this.author = "Luis-Eduardo Imbernón";
	}
	
	@PostConstruct
	public void init(){
		this.sensorInformation();
	}
	
	/**
	 * Getting the sensor data from the listeners
	 * @return
	 */
	public List<SensorObject> getSensorData(){
		return this.getSensorData();
	}
	
	@Override
	public void start() {
		//Do something
	}
	
	@Override
	public void stop() {
		//Do something
	}
}

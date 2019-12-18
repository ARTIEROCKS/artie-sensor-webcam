package artie.sensor.webcam.services;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.sarxos.webcam.Webcam;

import artie.sensor.common.dto.BufferedImageSerializable;
import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.services.ArtieClientSensorImpl;


@Service
public class WebcamService extends ArtieClientSensorImpl {
	
	//Attributes
	private Webcam webcam;
	private boolean started = false;
	
	
	/**
	 * About the sensor information
	 */
	private void sensorInformation(){
		this.name = "Webcam Sensor";
		this.version = "0.1.0";
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
		this.webcam = Webcam.getDefault();
        this.webcam.open();
        this.started = true;
	}
	
	@Override
	public void stop() {
		this.started = false;
		this.webcam.close();
	}
	
	@Scheduled(fixedRateString="${artie.sensor.webcam.collectdata.rate}")
	public void collectData(){
		if(this.started){
			BufferedImage image = this.webcam.getImage();
			BufferedImageSerializable imageSerializable = new BufferedImageSerializable(image);
			this.sensorData.add(new SensorObject(new Date(), imageSerializable));
		}
	}
}

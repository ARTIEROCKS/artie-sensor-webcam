package artie.sensor.webcam.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	private Logger logger = LoggerFactory.getLogger(WebcamService.class);
	
	@Value("${artie.sensor.webcam.name}")
	private String paramName;
	
	@Value("${artie.sensor.webcam.version}")
	private String paramVersion;
	
	@Value("${artie.sensor.webcam.author}")
	private String paramAuthor;

	
	
	/**
	 * About the sensor information
	 */
	private void sensorInformation(){
		this.name = this.paramName;
		this.version = this.paramVersion;
		this.author = this.paramVersion;
	}
	
	@PostConstruct
	public void init(){
		this.sensorInformation();
		this.isAlive = true;
	}
	
	/**
	 * Getting the sensor data from the listeners
	 * @return
	 */
	public List<SensorObject> getSensorData(){
		return this.sensorData;
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
			String strBis = "";
			
			try {
				strBis = imageSerializable.imageSerialization();
			} catch (IOException e) {
				this.logger.error(e.getMessage());
			}

			this.sensorData.add(new SensorObject(new Date(), strBis, "webcam"));
		}
	}
}

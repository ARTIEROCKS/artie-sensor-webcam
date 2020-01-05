package artie.sensor.webcam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import artie.sensor.common.dto.SensorObject;
import artie.sensor.common.interfaces.ArtieClientSensor;
import artie.sensor.webcam.services.WebcamService;

@Controller
public class WebcamController implements ArtieClientSensor {

	@Autowired
	private WebcamService webcamService;
	

	@GetMapping("/artie/sensor/webcam/getName")
	@ResponseBody
	public String getName(){
		return this.webcamService.getName();
	}
	
	@GetMapping("/artie/sensor/webcam/getVersion")
	@ResponseBody
	public String getVersion(){
		return this.webcamService.getVersion();
	}
	
	@GetMapping("/artie/sensor/webcam/getAuthor")
	@ResponseBody
	public String getAuthor(){
		return this.webcamService.getAuthor();
	}
	
	@GetMapping("/artie/sensor/webcam/isAlive")
	@ResponseBody
	public boolean getIsAlive() {
		return this.webcamService.getIsAlive();
	}
	
	@GetMapping("/artie/sensor/webcam/getConfiguration")
	@ResponseBody
	public Map<String, String> getConfiguration(){
		return this.webcamService.getConfiguration();
	}
	
	@PostMapping(path = "/artie/sensor/webcam/configuration")
	@ResponseBody
	public void setConfiguration(@RequestBody String configuration){
		this.webcamService.setConfiguration(configuration);
	}
	
	@Override
	public void setConfiguration(Map<String, String> configuration) {
		this.webcamService.setConfiguration(configuration);	
	}


	@GetMapping("/artie/sensor/webcam/start")
	@ResponseBody
	public void start(){
		this.webcamService.start();
	}
	
	@GetMapping("/artie/sensor/webcam/stop")
	@ResponseBody
	public void stop(){
		this.webcamService.stop();
	}
	
	@GetMapping("/artie/sensor/webcam/getSensorData")
	@ResponseBody
	public List<SensorObject> getSensorData(){
		return this.webcamService.getSensorData();
	}
	
	@GetMapping("/artie/sensor/webcam/sendSensorData")
	@ResponseBody
	public void sendSensorData() {
		this.webcamService.sendSensorData();		
	}

	
}

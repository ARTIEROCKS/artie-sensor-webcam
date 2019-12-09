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
import artie.sensor.webcam.services.SampleService;

@Controller
public class SampleController implements ArtieClientSensor {

	@Autowired
	private SampleService sampleService;
	

	@GetMapping("/artie/sensor/webcam/getName")
	@ResponseBody
	public String getName(){
		return this.sampleService.getName();
	}
	
	@GetMapping("/artie/sensor/webcam/getVersion")
	@ResponseBody
	public String getVersion(){
		return this.sampleService.getVersion();
	}
	
	@GetMapping("/artie/sensor/webcam/getAuthor")
	@ResponseBody
	public String getAuthor(){
		return this.sampleService.getAuthor();
	}
	
	@GetMapping("/artie/sensor/webcam/getConfiguration")
	@ResponseBody
	public Map<String, String> getConfiguration(){
		return this.sampleService.getConfiguration();
	}
	
	@PostMapping(path = "/artie/sensor/webcam/configuration", consumes = "application/json")
	public void setConfiguration(@RequestBody Map<String, String> configuration){
		this.sampleService.setConfiguration(configuration);
	}

	@GetMapping("/artie/sensor/webcam/start")
	@ResponseBody
	public void start(){
		this.sampleService.start();
	}
	
	@GetMapping("/artie/sensor/webcam/stop")
	@ResponseBody
	public void stop(){
		this.sampleService.stop();
	}
	
	@GetMapping("/artie/sensor/webcam/getSensorData")
	@ResponseBody
	public List<SensorObject> getSensorData(){
		return this.sampleService.getSensorData();
	}
	
}

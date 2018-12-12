package com.expolre.pattern.command.slot;

import com.expolre.pattern.command.Command;

public class StereoOffCommand implements Command{

	Stereo stereo;
	
	public StereoOffCommand(Stereo stereo){
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume();
	}
	
}

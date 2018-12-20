package com.expolre.pattern.command.queue;

import com.expolre.pattern.command.Command;

public class ReadCommand implements Command {

	@Override
	public void execute() {
		System.out.println(this.getClass());
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
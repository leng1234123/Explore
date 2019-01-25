package com.explore.pattern.command.queue;

import com.explore.pattern.command.Command;

public class AccpetCommand implements Command {

	@Override
	public void execute() {
		System.out.println(this.getClass());
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
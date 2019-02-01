package pers.allen.explore.pattern.aop;

import java.io.IOException;

public interface InputService{
		
	int read() throws IOException;
	
	int read(byte b[]) throws IOException;
	
	int read(byte b[], int off, int len) throws IOException;
}
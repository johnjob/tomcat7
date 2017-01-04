package com.chexing.bootstrap;

public class CoreDecortor implements Decorator {

	@Override
	public void invoke() {
		System.out.println("CoreDecortor");
	}

}

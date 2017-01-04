package com.chexing.bootstrap;

public class FirstDecorator extends ADeDecorator {

	public FirstDecorator(Decorator decorator) {
		super(decorator);
	}

	@Override
	public void invoke() {
		System.out.println("FirstDecorator");

		decorator.invoke();
	}

}

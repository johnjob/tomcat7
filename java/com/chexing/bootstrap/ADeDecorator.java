package com.chexing.bootstrap;

public abstract class ADeDecorator implements Decorator {
	protected Decorator decorator;
	public ADeDecorator(Decorator decorator) {
		this.decorator = decorator;
	}

	@Override
	public void invoke() {
		decorator.invoke();
	}
}

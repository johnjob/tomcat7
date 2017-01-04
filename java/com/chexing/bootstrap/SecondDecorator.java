package com.chexing.bootstrap;

public class SecondDecorator extends ADeDecorator {

	public SecondDecorator(Decorator decorator) {
		super(decorator);
	}

	@Override
	public void invoke() {
		
		System.out.println("SecondDecorator");
		super.invoke();

	}
	
	public static void main(String[] args) {
		CoreDecortor coreDecortor = new CoreDecortor();
		Decorator decorator = new SecondDecorator(new FirstDecorator(coreDecortor));
		decorator.invoke();
	}

}

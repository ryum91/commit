package content03;

public class FreeVariable {

	public void threadRun() {
		int temporary = 11;
		final int finalTemporary = 22;
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(temporary);			// Java7 에서는 Compile Error, Java8에서는 가능
				// temporary = 33;						// Compile Error
				System.out.println(finalTemporary);
			}
		});
		thread.run();
	}
}
package ch.sourcepond.maven.release.pom;

import static ch.sourcepond.maven.release.pom.Command.isSnapshot;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandTest {

	@Test
	public void verifyIsSnapshot() {
		assertFalse(isSnapshot(null));
		assertFalse(isSnapshot("1.0.2"));
		assertTrue(isSnapshot("1.0-SNAPSHOT"));
	}
}

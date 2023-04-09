package ar.unrn.eje3;

import java.time.LocalDate;

public class HelpDate implements Fecha {

	public HelpDate() {
		super();
	}

	@Override
	public LocalDate now() {
		return LocalDate.now();
	}
}

package proj.concert.service.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name ="SEATS")
@IdClass(SeatCompositeKey.class)
public class Seat {
	@Id
    private String label;
	@Id
	private LocalDateTime date;
	private BigDecimal cost;

	// if a seat has not been booked, its bookingID will be null. this does not prevent a seat from being booked twice.
	@ManyToOne
	@JoinColumn(name = "Booking_ID")
	private Booking booking;

	public Seat(String label, boolean isBooked, LocalDateTime date, BigDecimal cost) {
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public Seat() {}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}


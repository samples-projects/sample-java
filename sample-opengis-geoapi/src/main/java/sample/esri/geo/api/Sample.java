package sample.esri.geo.api;

import org.opengis.example.geometry.SimpleDirectPosition;
import org.opengis.example.geometry.SimpleEnvelope;
import org.opengis.example.referencing.SimpleCRS.Geographic;

public class Sample {

	private Sample() {
	}

	public static void main(String[] args) {
		SimpleDirectPosition lowerCorner = new SimpleDirectPosition(Geographic.WGS84, 1, 2);
		SimpleDirectPosition upperCorner = new SimpleDirectPosition(Geographic.WGS84, 3, 4);
		SimpleEnvelope simpleEnvelope = new SimpleEnvelope(lowerCorner, upperCorner);
		
		System.out.println(simpleEnvelope.toString());
	}
}

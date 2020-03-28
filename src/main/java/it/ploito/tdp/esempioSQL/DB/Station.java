package it.ploito.tdp.esempioSQL.DB;

public class Station {
	
	private int id;
	private String name;
	private int docKCount;
	private String landmark;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param docKCount
	 * @param landmark
	 */
	public Station(int id, String name, int docKCount, String landmark) {
		super();
		this.id = id;
		this.name = name;
		this.docKCount = docKCount;
		this.landmark = landmark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDocKCount() {
		return docKCount;
	}

	public void setDocKCount(int docKCount) {
		this.docKCount = docKCount;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	
	
}

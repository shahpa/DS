package com.khanna111.graph.directed.weights;

public class Vertex {

    public int id;

    public Vertex(int id) {
	super();
	this.id = id;
    }

    public int getId() {
        return id;
    }
    
  
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Vertex other = (Vertex) obj;
	if (id != other.id)
	    return false;
	return true;
    }

}

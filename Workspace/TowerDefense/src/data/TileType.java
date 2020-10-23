package data;

public enum TileType {
	
	Grass("GrassTexture", true), Dirt("DirtTexture", false), Water("WaterTexture", false), NULL("WaterTexture", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName=textureName;
		this.buildable = buildable;
	}
}

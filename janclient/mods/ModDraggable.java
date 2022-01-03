package janclient.mods;

import java.io.File;

import janclient.FileManager;
import janclient.hudmanager.IRenderer;
import janclient.hudmanager.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer{

	protected ScreenPosition pos;
	
	public ModDraggable() {
		pos = loadPositionFromFile();
	}
	
	private ScreenPosition loadPositionFromFile() {
		// TODO Auto-generated method stub
		ScreenPosition loaded = FileManager.readFromJson(new File(getFolder(), "pos.json"), ScreenPosition.class);
		
		if(loaded == null) {
			loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
			this.pos = loaded;
			savePositionToFile();
		}
		
		return loaded;
	}

	@Override
	public ScreenPosition load() {
		// TODO Auto-generated method stub
		return pos;
		
	}
	@Override
	public void save(ScreenPosition pos) {
		// TODO Auto-generated method stub
		this.pos = pos;
		savePositionToFile();
	}
	
	private File getFolder() {
		File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
		folder.mkdirs();
		return folder;
	}
	
	private void savePositionToFile() {
		// TODO Auto-generated method stub
		FileManager.writeJsonToFile(new File(getFolder(), "pos.json"), pos);
	}

	public final int getLineOffset(ScreenPosition pos, int lineNum) {
		return pos.getAbsoluteY() + getLineOffset(lineNum);
	}

	private int getLineOffset(int lineNum) {
		// TODO Auto-generated method stub
		return (font.FONT_HEIGHT + 3) * lineNum;
	}
	
}

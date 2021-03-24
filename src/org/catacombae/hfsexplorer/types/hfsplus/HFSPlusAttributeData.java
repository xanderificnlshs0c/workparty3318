package org.catacombae.hfsexplorer.types.hfsplus;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;

/** This class was generated by CStructToJavaClass. */
public class HFSPlusAttributeData {
    /*
     * struct HFSPlusAttrData
     * size: 18 bytes
     * description: 
     * 
     * BP  Size  Type       Identifier  Description                       
     * -------------------------------------------------------------------
     * 0   4     UInt32     recordType  // == kHFSPlusAttrInlineData      
     * 4   4*2   UInt32[2]  reserved                                      
     * 12  4     UInt32     attrSize    // size of attribute data in bytes
     * 16  1*2   UInt8[2]   attrData    // variable length                
     */
	public static final int HFS_PLUS_ATTR_INLINEDATA =  0x10;   // attributes whose data fits in a b-tree node
	public static final int HFS_PLUS_ATTR_FORKDATA = 0x20;   // extent based attributes (data lives in extents)
	public static final int HFS_PLUS_ATTR_EXTENTS = 0x30;    // overf
	
    public static final int STRUCTSIZE = 18;
    
    private final byte[] recordType = new byte[4];
    private final byte[] reserved = new byte[4*2];
    private final byte[] attrSize = new byte[4];
    private final byte[] attrData;
    
    public HFSPlusAttributeData(byte[] data, int offset) {
	System.arraycopy(data, offset+0, recordType, 0, 4);
	System.arraycopy(data, offset+4, reserved, 0, 4*2);
	System.arraycopy(data, offset+12, attrSize, 0, 4);
	attrData = new byte[getAttrSize()];
	System.arraycopy(data, offset+16, attrData, 0, getAttrSize());
    }
    
    public static int length() { return STRUCTSIZE; }
    
    /** // == kHFSPlusAttrInlineData */
    public int getRecordType() { return Util.readIntBE(recordType); }
    /**  */
    public int[] getReserved() { return Util.readIntArrayBE(reserved); }
    /** // size of attribute data in bytes */
    public int getAttrSize() { return Util.readIntBE(attrSize); }
    /** // variable length */
    public byte[] getAttrData() { return Util.readByteArrayBE(attrData); }
    
    public void printFields(PrintStream ps, String prefix) {
	ps.println(prefix + " recordType: " + getRecordType());
	ps.println(prefix + " reserved: " + getReserved());
	ps.println(prefix + " attrSize: " + getAttrSize());
	ps.println(prefix + " attrData: " + getAttrData());
    }
    
    public void print(PrintStream ps, String prefix) {
	ps.println(prefix + "HFSPlusAttrData:");
	printFields(ps, prefix);
    }
    
    public byte[] getBytes() {
	byte[] result = new byte[STRUCTSIZE];
	byte[] tempData;
	int offset = 0;
	System.arraycopy(recordType, 0, result, offset, recordType.length); offset += recordType.length;
	System.arraycopy(reserved, 0, result, offset, reserved.length); offset += reserved.length;
	System.arraycopy(attrSize, 0, result, offset, attrSize.length); offset += attrSize.length;
	System.arraycopy(attrData, 0, result, offset, attrData.length); offset += attrData.length;
	return result;
    }
}

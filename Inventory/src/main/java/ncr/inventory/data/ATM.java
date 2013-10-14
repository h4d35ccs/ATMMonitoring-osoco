package ncr.inventory.data;

import java.util.Vector;

import org.apache.log4j.Logger;

//Cada ATM puede tener:

//FABRICANTE:
//NCR
//	- Terminal
//	- Financial Device Inventory
//	- Software - Package

//WINCOR:

//DIEBOLD:

//COMUNES:
//Software
//	- Product
//	- Hotfix
//	- IExplorer
//	- Package - NCR (*)
//	- Operating System

//Hardware
//	- ComputerSystem
//	- BaseBoard
//	- Bios
//	- PhysicalMemory
//	- Processor
//	- DiskDrive
//	- CDROMDrive
//	- FloppyDrive
//	- LogicalDisk
//	- VideoController
//	- SerialPort
//	- ParallelPort
//	- SCSIController
//	- USBController
//	- UsbHub
//	- SoundDevice
//	- NetworkAdapterSetting
//	- 1394Controller
//	- DesktopMonitor
//	- Keyboard
//	- PointingDevice
//	- SystemSlot

public class ATM {
    private String ip = null;
    private String mac = null;

    private Vector<Terminal> mTerminal = null;
    private Vector<Device> mDevice = null;
    private Vector<Package> mPackage = null;

    private Vector<Product> mProduct = null;
    private Vector<Hotfix> mHotfix = null;
    private Vector<IExplorer> mIExplorer = null;
    private Vector<OperatingSystem> mOperatingSystem = null;

    private Vector<ComputerSystem> mComputerSystem = null;
    private Vector<BaseBoard> mBaseBoard = null;
    private Vector<Bios> mBios = null;
    private Vector<PhysicalMemory> mPhysicalMemory = null;
    private Vector<Processor> mProcessor = null;
    private Vector<DiskDrive> mDiskDrive = null;
    private Vector<CDROMDrive> mCDROMDrive = null;
    private Vector<FloppyDrive> mFloppyDrive = null;
    private Vector<LogicalDisk> mLogicalDisk = null;
    private Vector<VideoController> mVideoController = null;
    private Vector<SerialPort> mSerialPort = null;
    private Vector<ParallelPort> mParallelPort = null;
    private Vector<SCSIController> mSCSIController = null;
    private Vector<USBController> mUSBController = null;
    private Vector<UsbHub> mUsbHub = null;
    private Vector<SoundDevice> mSoundDevice = null;
    private Vector<NetworkAdapterSetting> mNetworkAdapterSetting = null;
    private Vector<_1394Controller> m1394Controller = null;
    private Vector<DesktopMonitor> mDesktopMonitor = null;
    private Vector<Keyboard> mKeyboard = null;
    private Vector<PointingDevice> mPointingDevice = null;
    private Vector<SystemSlot> mSystemSlot = null;

    static Logger logger = Logger.getLogger(ATM.class.getName());

    public ATM(String ip, String mac) {
		this.ip = ip;
		this.mac = mac;
    }

    public String getIp() {
    	return ip;
    }

    public String getMac() {
    	return mac;
    }

    public void setTerminal(Terminal t) {
		if (mTerminal == null)
		    mTerminal = new Vector<Terminal>();
	
		mTerminal.addElement(t);
    }

    public Vector<Terminal> getTerminals() {
    	return mTerminal;
    }

    public void setDevice(Device d) {
		if (mDevice == null)
		    mDevice = new Vector<Device>();

		mDevice.addElement(d);
    }

    public void setPackage(Package t) {
		if (mPackage == null)
		    mPackage = new Vector<Package>();
	
		mPackage.addElement(t);
    }

    public void setProduct(Product p) {
		if (mProduct == null)
		    mProduct = new Vector<Product>();
	
		mProduct.addElement(p);
    }

    public void setHotfix(Hotfix d) {
		if (mHotfix == null)
		    mHotfix = new Vector<Hotfix>();
	
		mHotfix.addElement(d);
    }

    public void setIExplorer(IExplorer ie) {
		if (mIExplorer == null)
		    mIExplorer = new Vector<IExplorer>();
	
		mIExplorer.addElement(ie);
    }

    public void setOperatingSystem(OperatingSystem os) {
		if (mOperatingSystem == null)
		    mOperatingSystem = new Vector<OperatingSystem>();
	
		mOperatingSystem.addElement(os);
    }

    public void setComputerSystem(ComputerSystem cs) {
		if (mComputerSystem == null)
		    mComputerSystem = new Vector<ComputerSystem>();
	
		mComputerSystem.addElement(cs);
    }

    public void setBaseBoard(BaseBoard bb) {
		if (mBaseBoard == null)
		    mBaseBoard = new Vector<BaseBoard>();
	
		mBaseBoard.addElement(bb);
    }

    public void setBios(Bios b) {
		if (mBios == null)
		    mBios = new Vector<Bios>();
	
		mBios.addElement(b);
    }

    public void setPhysicalMemory(PhysicalMemory pm) {
		if (mPhysicalMemory == null)
		    mPhysicalMemory = new Vector<PhysicalMemory>();
	
		mPhysicalMemory.addElement(pm);
    }

    public void setProcessor(Processor pr) {
		if (mProcessor == null)
		    mProcessor = new Vector<Processor>();
	
		mProcessor.addElement(pr);
    }

    public void setDiskDrive(DiskDrive dd) {
		if (mDiskDrive == null)
		    mDiskDrive = new Vector<DiskDrive>();
	
		mDiskDrive.addElement(dd);
    }

    public void setCDROMDrive(CDROMDrive cd) {
		if (mCDROMDrive == null)
		    mCDROMDrive = new Vector<CDROMDrive>();
	
		mCDROMDrive.addElement(cd);
    }

    public void setFloppyDrive(FloppyDrive fp) {
		if (mFloppyDrive == null)
		    mFloppyDrive = new Vector<FloppyDrive>();
	
		mFloppyDrive.addElement(fp);
    }

    public void setLogicalDisk(LogicalDisk ld) {
		if (mLogicalDisk == null)
		    mLogicalDisk = new Vector<LogicalDisk>();
	
		mLogicalDisk.addElement(ld);
    }

    public void setVideoController(VideoController vc) {
		if (mVideoController == null)
		    mVideoController = new Vector<VideoController>();
	
		mVideoController.addElement(vc);
    }

    public void setSerialPort(SerialPort sp) {
		if (mSerialPort == null)
		    mSerialPort = new Vector<SerialPort>();
	
		mSerialPort.addElement(sp);
    }

    public void setParallelPort(ParallelPort pp) {
		if (mParallelPort == null)
		    mParallelPort = new Vector<ParallelPort>();
	
		mParallelPort.addElement(pp);
    }

    public void setSCSIController(SCSIController sc) {
		if (mSCSIController == null)
		    mSCSIController = new Vector<SCSIController>();
	
		mSCSIController.addElement(sc);
    }

    public void setUSBController(USBController uc) {
		if (mUSBController == null)
		    mUSBController = new Vector<USBController>();
	
		mUSBController.addElement(uc);
    }

    public void setUsbHub(UsbHub uh) {
		if (mUsbHub == null)
		    mUsbHub = new Vector<UsbHub>();
	
		mUsbHub.addElement(uh);
    }

    public void setSoundDevice(SoundDevice sd) {
		if (mSoundDevice == null)
		    mSoundDevice = new Vector<SoundDevice>();
	
		mSoundDevice.addElement(sd);
    }

    public void setNetworkAdapterSetting(NetworkAdapterSetting nas) {
		if (mNetworkAdapterSetting == null)
		    mNetworkAdapterSetting = new Vector<NetworkAdapterSetting>();
	
		mNetworkAdapterSetting.addElement(nas);
    }

    public void set1394Controller(_1394Controller c) {
		if (m1394Controller == null)
		    m1394Controller = new Vector<_1394Controller>();
	
		m1394Controller.addElement(c);
    }

    public void setDesktopMonitor(DesktopMonitor dm) {
		if (mDesktopMonitor == null)
		    mDesktopMonitor = new Vector<DesktopMonitor>();
	
		mDesktopMonitor.addElement(dm);
    }

    public void setKeyboard(Keyboard kb) {
		if (mKeyboard == null)
		    mKeyboard = new Vector<Keyboard>();
	
		mKeyboard.addElement(kb);
    }

    public void setPointingDevice(PointingDevice pd) {
		if (mPointingDevice == null)
		    mPointingDevice = new Vector<PointingDevice>();
	
		mPointingDevice.addElement(pd);
    }

    public void setSystemSlot(SystemSlot ss) {
		if (mSystemSlot == null)
		    mSystemSlot = new Vector<SystemSlot>();
	
		mSystemSlot.addElement(ss);
    }

    public Vector<Terminal> getmTerminal() {
    	return mTerminal;
    }

    public Vector<Device> getmDevice() {
    	return mDevice;
    }

    public Vector<Package> getmPackage() {
    	return mPackage;
    }

    public Vector<Product> getmProduct() {
    	return mProduct;
    }

    public Vector<Hotfix> getmHotfix() {
    	return mHotfix;
    }

    public Vector<IExplorer> getmIExplorer() {
    	return mIExplorer;
    }

    public Vector<OperatingSystem> getmOperatingSystem() {
    	return mOperatingSystem;
    }

    public Vector<ComputerSystem> getmComputerSystem() {
    	return mComputerSystem;
    }

    public Vector<BaseBoard> getmBaseBoard() {
    	return mBaseBoard;
    }

    public Vector<Bios> getmBios() {
    	return mBios;
    }

    public Vector<PhysicalMemory> getmPhysicalMemory() {
    	return mPhysicalMemory;
    }

    public Vector<Processor> getmProcessor() {
    	return mProcessor;
    }

    public Vector<DiskDrive> getmDiskDrive() {
    	return mDiskDrive;
    }

    public Vector<CDROMDrive> getmCDROMDrive() {
    	return mCDROMDrive;
    }

    public Vector<FloppyDrive> getmFloppyDrive() {
    	return mFloppyDrive;
    }

    public Vector<LogicalDisk> getmLogicalDisk() {
    	return mLogicalDisk;
    }

    public Vector<VideoController> getmVideoController() {
    	return mVideoController;
    }

    public Vector<SerialPort> getmSerialPort() {
    	return mSerialPort;
    }

    public Vector<ParallelPort> getmParallelPort() {
    	return mParallelPort;
    }

    public Vector<SCSIController> getmSCSIController() {
    	return mSCSIController;
    }

    public Vector<USBController> getmUSBController() {
    	return mUSBController;
    }

    public Vector<UsbHub> getmUsbHub() {
    	return mUsbHub;
    }

    public Vector<SoundDevice> getmSoundDevice() {
    	return mSoundDevice;
    }

    public Vector<NetworkAdapterSetting> getmNetworkAdapterSetting() {
    	return mNetworkAdapterSetting;
    }

    public Vector<_1394Controller> getM1394Controller() {
    	return m1394Controller;
    }

    public Vector<DesktopMonitor> getmDesktopMonitor() {
    	return mDesktopMonitor;
    }

    public Vector<Keyboard> getmKeyboard() {
    	return mKeyboard;
    }

    public Vector<PointingDevice> getmPointingDevice() {
    	return mPointingDevice;
    }

    public Vector<SystemSlot> getmSystemSlot() {
    	return mSystemSlot;
    }

}
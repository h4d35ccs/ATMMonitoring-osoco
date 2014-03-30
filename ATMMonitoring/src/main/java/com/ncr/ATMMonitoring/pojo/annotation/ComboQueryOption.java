package com.ncr.ATMMonitoring.pojo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a field as elegible for generating the query combo box
 * 
 * @author Otto Abreu
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ComboQueryOption {

    boolean USE_VERSION_COMPARISON = true;

    /**
     * GROUP_HARDWARE_COMPUTER_SYSTEM = "Win32_ComputerSystem";
     */
    String GROUP_HARDWARE_COMPUTER_SYSTEM = "Win32_ComputerSystem";
    /**
     * GROUP_HARDWARE_PROCESSOR = "Win32_Processor";
     */
    String GROUP_HARDWARE_PROCESSOR = "Win32_Processor";
    /**
     * GROUP_HARDWARE_PHYSICAL_MEMORY = "Win32_PhysicalMemory";
     */
    String GROUP_HARDWARE_PHYSICAL_MEMORY = "Win32_PhysicalMemory";
    /**
     * GROUP_HARDWARE_DISK_DRIVE = "Win32_DiskDrive";
     */
    String GROUP_HARDWARE_DISK_DRIVE = "Win32_DiskDrive";
    /**
     * GROUP_HARDWARE_LOGICAL_DISK = "Win32_LogicalDisk";
     */
    String GROUP_HARDWARE_LOGICAL_DISK = "Win32_LogicalDisk";
    /**
     * GROUP_HARDWARE_BASE_BOARD = "Win32_BaseBoard";
     */
    String GROUP_HARDWARE_BASE_BOARD = "Win32_BaseBoard";
    /**
     * GROUP_HARDWARE_NETWORK_ADAPTER = "Win32_NetworkAdapter";
     */
    String GROUP_HARDWARE_NETWORK_ADAPTER = "Win32_NetworkAdapter";
    /**
     * GROUP_HARDWARE_FLOPPY_DRIVE = "Win32_FloppyDrive";
     */
    String GROUP_HARDWARE_FLOPPY_DRIVE = "Win32_FloppyDrive";
    /**
     * GROUP_HARDWARE_CDROM_DRIVE = "Win32_CDROMDrive";
     */
    String GROUP_HARDWARE_CDROM_DRIVE = "Win32_CDROMDrive";
    /**
     * GROUP_HARDWARE_SOUND_DEVICE = "Win32_SoundDevice";
     */
    String GROUP_HARDWARE_SOUND_DEVICE = "Win32_SoundDevice";
    /**
     * GROUP_HARDWARE_DISPLAY_CONFIGURATION = "Win32_DisplayConfiguration";
     */
    String GROUP_HARDWARE_DISPLAY_CONFIGURATION = "Win32_DisplayConfiguration";
    /**
     * GROUP_HARDWARE_USB_CONTROLLER = "Win32_USBController";
     */
    String GROUP_HARDWARE_USB_CONTROLLER = "Win32_USBController";
    /**
     * GROUP_HARDWARE_USB_HUB = "Win32_USBHub";
     */
    String GROUP_HARDWARE_USB_HUB = "Win32_USBHub";
    /**
     * GROUP_HARDWARE_SERIAL_PORT = "Win32_SerialPort";
     */
    String GROUP_HARDWARE_SERIAL_PORT = "Win32_SerialPort";
    /**
     * GROUP_HARDWARE_PARALLEL_PORT = "Win32_ParallelPort";
     */
    String GROUP_HARDWARE_PARALLEL_PORT = "Win32_ParallelPort";
    /**
     * GROUP_HARDWARE_1394_CONTROLLER = "Win32_1394Controller"
     */
    String GROUP_HARDWARE_1394_CONTROLLER = "Win32_1394Controller";
    /**
     * GROUP_HARDWARE_SCSI_CONTROLLER = "Win32_SCSIController";
     */
    String GROUP_HARDWARE_SCSI_CONTROLLER = "Win32_SCSIController";
    /**
     * GROUP_HARDWARE_DESKTOP_MONITOR = "Win32_DesktopMonitor";
     */
    String GROUP_HARDWARE_DESKTOP_MONITOR = "Win32_DesktopMonitor";
    /**
     * GROUP_HARDWARE_KEYBOARD = "Win32_Keyboard";
     */
    String GROUP_HARDWARE_KEYBOARD = "Win32_Keyboard";
    /**
     * GROUP_HARDWARE_POINTING_DEVICE = "Win32_PointingDevice";
     */
    String GROUP_HARDWARE_POINTING_DEVICE = "Win32_PointingDevice";
    /**
     * GROUP_HARDWARE_SYSTEM_SLOT = "Win32_SystemSlot";
     */
    String GROUP_HARDWARE_SYSTEM_SLOT = "Win32_SystemSlot";
    /**
     * GROUP_HARDWARE_BIOS = "Win32_Bios";
     */
    String GROUP_HARDWARE_BIOS = "Win32_Bios";
    /**
     * GROUP_HARDWARE_VIDEO_CONTROLLER = "Win32_VideoController";
     */
    String GROUP_HARDWARE_VIDEO_CONTROLLER = "Win32_VideoController";
    /**
     * GROUP_HARDWARE_ALL = true;
     */
    boolean GROUP_HARDWARE_ALL = true;

    /**
     * Indicate that the field belong exclusively to a certain group that uses
     * different comparison options
     * 
     * @return
     */
    String[] belongsToGroups() default {};

    /**
     * Indicate that the field is not part of certain groups meaning that
     * belongs to all that are not defined here
     * 
     * @return
     */
    String[] doNotBelongsToGroups() default {};

    /**
     * Indicate that the field is being used in all groups
     * 
     * @return
     */
    boolean belongToAllGroups() default false;

    /**
     * Tells if the field will use the version comparison options Use
     * {@link ComboQueryOption#USE_VERSION_COMPARISON} to indicate that the
     * field will use this type of options
     * 
     * @return boolean
     */
    boolean versionComparison() default false;

}

package com.ncr.ATMMonitoring.pojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.type.Type;

import com.ncr.ATMMonitoring.utils.Operation;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Entity
@Table(name = "queries")
public class Query {

    private static final Map<String, Map> comboboxes;

    static {
	comboboxes = new TreeMap<String, Map>();
	comboboxes.put("terminal", Terminal.getComboboxes());
	comboboxes.put("financialDevice", FinancialDevice.getComboboxes());
	comboboxes.put("hotfix", Hotfix.getComboboxes());
	comboboxes.put("internetExplorer", InternetExplorer.getComboboxes());
	comboboxes.put("operatingSystem", OperatingSystem.getComboboxes());
	comboboxes.put("software", Software.getComboboxes());
	comboboxes.put("xfsSw", Software.getComboboxes());
	comboboxes.put("featSw", Software.getComboboxes());
	comboboxes.put("hardwareDevice", HardwareDevice.getComboboxes());
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "queries_id_seq")
    @SequenceGenerator(name = "queries_id_seq", sequenceName = "queries_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "query_name", length = 50, nullable = false)
    private String name = "";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "query", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Set<ScheduledUpdate> scheduledUpdates = new HashSet<ScheduledUpdate>();

    @Column(name = "locale", length = 10)
    private String locale;

    @Column(name = "terminal_c11", length = 50)
    private String terminalCombo11 = "";

    @Column(name = "terminal_c12", length = 50)
    private String terminalCombo12 = "";

    @Column(name = "terminal_cb1")
    private Boolean terminalCB1 = false;

    @Column(name = "terminal_f1", length = 150)
    private String terminalField1 = "";

    @Column(name = "terminal_c21", length = 50)
    private String terminalCombo21 = "";

    @Column(name = "terminal_c22", length = 50)
    private String terminalCombo22 = "";

    @Column(name = "terminal_cb2")
    private Boolean terminalCB2 = false;

    @Column(name = "terminal_f2", length = 150)
    private String terminalField2 = "";

    @Column(name = "terminal_c31", length = 50)
    private String terminalCombo31 = "";

    @Column(name = "terminal_c32", length = 50)
    private String terminalCombo32 = "";

    @Column(name = "terminal_cb3")
    private Boolean terminalCB3 = false;

    @Column(name = "terminal_f3", length = 150)
    private String terminalField3 = "";

    @Column(name = "terminal_c41", length = 50)
    private String terminalCombo41 = "";

    @Column(name = "terminal_c42", length = 50)
    private String terminalCombo42 = "";

    @Column(name = "terminal_cb4")
    private Boolean terminalCB4 = false;

    @Column(name = "terminal_f4", length = 150)
    private String terminalField4 = "";

    @Column(name = "terminal_c51", length = 50)
    private String terminalCombo51 = "";

    @Column(name = "terminal_c52", length = 50)
    private String terminalCombo52 = "";

    @Column(name = "terminal_cb5")
    private Boolean terminalCB5 = false;

    @Column(name = "terminal_f5", length = 150)
    private String terminalField5 = "";

    @Column(name = "financial_dev_c11", length = 50)
    private String financialDeviceCombo11 = "";

    @Column(name = "financial_dev_c12", length = 50)
    private String financialDeviceCombo12 = "";

    @Column(name = "financial_dev_cb1")
    private Boolean financialDeviceCB1 = false;

    @Column(name = "financial_dev_f1", length = 150)
    private String financialDeviceField1 = "";

    @Column(name = "financial_dev_c21", length = 50)
    private String financialDeviceCombo21 = "";

    @Column(name = "financial_dev_c22", length = 50)
    private String financialDeviceCombo22 = "";

    @Column(name = "financial_dev_cb2")
    private Boolean financialDeviceCB2 = false;

    @Column(name = "financial_dev_f2", length = 150)
    private String financialDeviceField2 = "";

    @Column(name = "financial_dev_c31", length = 50)
    private String financialDeviceCombo31 = "";

    @Column(name = "financial_dev_c32", length = 50)
    private String financialDeviceCombo32 = "";

    @Column(name = "financial_dev_cb3")
    private Boolean financialDeviceCB3 = false;

    @Column(name = "financial_dev_f3", length = 150)
    private String financialDeviceField3 = "";

    @Column(name = "financial_dev_c41", length = 50)
    private String financialDeviceCombo41 = "";

    @Column(name = "financial_dev_c42", length = 50)
    private String financialDeviceCombo42 = "";

    @Column(name = "financial_dev_cb4")
    private Boolean financialDeviceCB4 = false;

    @Column(name = "financial_dev_f4", length = 150)
    private String financialDeviceField4 = "";

    @Column(name = "financial_dev_c51", length = 50)
    private String financialDeviceCombo51 = "";

    @Column(name = "financial_dev_c52", length = 50)
    private String financialDeviceCombo52 = "";

    @Column(name = "financial_dev_cb5")
    private Boolean financialDeviceCB5 = false;

    @Column(name = "financial_dev_f5", length = 150)
    private String financialDeviceField5 = "";

    @Column(name = "hotfix_c11", length = 50)
    private String hotfixCombo11 = "";

    @Column(name = "hotfix_c12", length = 50)
    private String hotfixCombo12 = "";

    @Column(name = "hotfix_cb1")
    private Boolean hotfixCB1 = false;

    @Column(name = "hotfix_f1", length = 150)
    private String hotfixField1 = "";

    @Column(name = "hotfix_c21", length = 50)
    private String hotfixCombo21 = "";

    @Column(name = "hotfix_c22", length = 50)
    private String hotfixCombo22 = "";

    @Column(name = "hotfix_cb2")
    private Boolean hotfixCB2 = false;

    @Column(name = "hotfix_f2", length = 150)
    private String hotfixField2 = "";

    @Column(name = "hotfix_c31", length = 50)
    private String hotfixCombo31 = "";

    @Column(name = "hotfix_c32", length = 50)
    private String hotfixCombo32 = "";

    @Column(name = "hotfix_cb3")
    private Boolean hotfixCB3 = false;

    @Column(name = "hotfix_f3", length = 150)
    private String hotfixField3 = "";

    @Column(name = "hotfix_c41", length = 50)
    private String hotfixCombo41 = "";

    @Column(name = "hotfix_c42", length = 50)
    private String hotfixCombo42 = "";

    @Column(name = "hotfix_cb4")
    private Boolean hotfixCB4 = false;

    @Column(name = "hotfix_f4", length = 150)
    private String hotfixField4 = "";

    @Column(name = "hotfix_c51", length = 50)
    private String hotfixCombo51 = "";

    @Column(name = "hotfix_c52", length = 50)
    private String hotfixCombo52 = "";

    @Column(name = "hotfix_cb5")
    private Boolean hotfixCB5 = false;

    @Column(name = "hotfix_f5", length = 150)
    private String hotfixField5 = "";

    @Column(name = "ie_c11", length = 50)
    private String internetExplorerCombo11 = "";

    @Column(name = "ie_c12", length = 50)
    private String internetExplorerCombo12 = "";

    @Column(name = "ie_cb1")
    private Boolean internetExplorerCB1 = false;

    @Column(name = "ie_f1", length = 150)
    private String internetExplorerField1 = "";

    @Column(name = "ie_c21", length = 50)
    private String internetExplorerCombo21 = "";

    @Column(name = "ie_c22", length = 50)
    private String internetExplorerCombo22 = "";

    @Column(name = "ie_cb2")
    private Boolean internetExplorerCB2 = false;

    @Column(name = "ie_f2", length = 150)
    private String internetExplorerField2 = "";

    @Column(name = "op_system_c11", length = 50)
    private String operatingSystemCombo11 = "";

    @Column(name = "op_system_c12", length = 50)
    private String operatingSystemCombo12 = "";

    @Column(name = "op_system_cb1")
    private Boolean operatingSystemCB1 = false;

    @Column(name = "op_system_f1", length = 150)
    private String operatingSystemField1 = "";

    @Column(name = "op_system_c21", length = 50)
    private String operatingSystemCombo21 = "";

    @Column(name = "op_system_c22", length = 50)
    private String operatingSystemCombo22 = "";

    @Column(name = "op_system_cb2")
    private Boolean operatingSystemCB2 = false;

    @Column(name = "op_system_f2", length = 150)
    private String operatingSystemField2 = "";

    @Column(name = "op_system_c31", length = 50)
    private String operatingSystemCombo31 = "";

    @Column(name = "op_system_c32", length = 50)
    private String operatingSystemCombo32 = "";

    @Column(name = "op_system_cb3")
    private Boolean operatingSystemCB3 = false;

    @Column(name = "op_system_f3", length = 150)
    private String operatingSystemField3 = "";

    @Column(name = "op_system_c41", length = 50)
    private String operatingSystemCombo41 = "";

    @Column(name = "op_system_c42", length = 50)
    private String operatingSystemCombo42 = "";

    @Column(name = "op_system_cb4")
    private Boolean operatingSystemCB4 = false;

    @Column(name = "op_system_f4", length = 150)
    private String operatingSystemField4 = "";

    @Column(name = "op_system_c51", length = 50)
    private String operatingSystemCombo51 = "";

    @Column(name = "op_system_c52", length = 50)
    private String operatingSystemCombo52 = "";

    @Column(name = "op_system_cb5")
    private Boolean operatingSystemCB5 = false;

    @Column(name = "op_system_f5", length = 150)
    private String operatingSystemField5 = "";

    @Column(name = "software_c11", length = 50)
    private String softwareCombo11 = "";

    @Column(name = "software_c12", length = 50)
    private String softwareCombo12 = "";

    @Column(name = "software_cb1")
    private Boolean softwareCB1 = false;

    @Column(name = "software_f1", length = 150)
    private String softwareField1 = "";

    @Column(name = "software_c21", length = 50)
    private String softwareCombo21 = "";

    @Column(name = "software_c22", length = 50)
    private String softwareCombo22 = "";

    @Column(name = "software_cb2")
    private Boolean softwareCB2 = false;

    @Column(name = "software_f2", length = 150)
    private String softwareField2 = "";

    @Column(name = "software_c31", length = 50)
    private String softwareCombo31 = "";

    @Column(name = "software_c32", length = 50)
    private String softwareCombo32 = "";

    @Column(name = "software_cb3")
    private Boolean softwareCB3 = false;

    @Column(name = "software_f3", length = 150)
    private String softwareField3 = "";

    @Column(name = "software_c41", length = 50)
    private String softwareCombo41 = "";

    @Column(name = "software_c42", length = 50)
    private String softwareCombo42 = "";

    @Column(name = "software_cb4")
    private Boolean softwareCB4 = false;

    @Column(name = "software_f4", length = 150)
    private String softwareField4 = "";

    @Column(name = "software_c51", length = 50)
    private String softwareCombo51 = "";

    @Column(name = "software_c52", length = 50)
    private String softwareCombo52 = "";

    @Column(name = "software_cb5")
    private Boolean softwareCB5 = false;

    @Column(name = "software_f5", length = 150)
    private String softwareField5 = "";

    @Column(name = "xfs_sw_c11", length = 50)
    private String xfsSwCombo11 = "";

    @Column(name = "xfs_sw_c12", length = 50)
    private String xfsSwCombo12 = "";

    @Column(name = "xfs_sw_cb1")
    private Boolean xfsSwCB1 = false;

    @Column(name = "xfs_sw_f1", length = 150)
    private String xfsSwField1 = "";

    @Column(name = "xfs_sw_c21", length = 50)
    private String xfsSwCombo21 = "";

    @Column(name = "xfs_sw_c22", length = 50)
    private String xfsSwCombo22 = "";

    @Column(name = "xfs_sw_cb2")
    private Boolean xfsSwCB2 = false;

    @Column(name = "xfs_sw_f2", length = 150)
    private String xfsSwField2 = "";

    @Column(name = "xfs_sw_c31", length = 50)
    private String xfsSwCombo31 = "";

    @Column(name = "xfs_sw_c32", length = 50)
    private String xfsSwCombo32 = "";

    @Column(name = "xfs_sw_cb3")
    private Boolean xfsSwCB3 = false;

    @Column(name = "xfs_sw_f3", length = 150)
    private String xfsSwField3 = "";

    @Column(name = "xfs_sw_c41", length = 50)
    private String xfsSwCombo41 = "";

    @Column(name = "xfs_sw_c42", length = 50)
    private String xfsSwCombo42 = "";

    @Column(name = "xfs_sw_cb4")
    private Boolean xfsSwCB4 = false;

    @Column(name = "xfs_sw_f4", length = 150)
    private String xfsSwField4 = "";

    @Column(name = "xfs_sw_c51", length = 50)
    private String xfsSwCombo51 = "";

    @Column(name = "xfs_sw_c52", length = 50)
    private String xfsSwCombo52 = "";

    @Column(name = "xfs_sw_cb5")
    private Boolean xfsSwCB5 = false;

    @Column(name = "xfs_sw_f5", length = 150)
    private String xfsSwField5 = "";

    @Column(name = "feat_sw_c11", length = 50)
    private String featSwCombo11 = "";

    @Column(name = "feat_sw_c12", length = 50)
    private String featSwCombo12 = "";

    @Column(name = "feat_sw_cb1")
    private Boolean featSwCB1 = false;

    @Column(name = "feat_sw_f1", length = 150)
    private String featSwField1 = "";

    @Column(name = "feat_sw_c21", length = 50)
    private String featSwCombo21 = "";

    @Column(name = "feat_sw_c22", length = 50)
    private String featSwCombo22 = "";

    @Column(name = "feat_sw_cb2")
    private Boolean featSwCB2 = false;

    @Column(name = "feat_sw_f2", length = 150)
    private String featSwField2 = "";

    @Column(name = "feat_sw_c31", length = 50)
    private String featSwCombo31 = "";

    @Column(name = "feat_sw_c32", length = 50)
    private String featSwCombo32 = "";

    @Column(name = "feat_sw_cb3")
    private Boolean featSwCB3 = false;

    @Column(name = "feat_sw_f3", length = 150)
    private String featSwField3 = "";

    @Column(name = "feat_sw_c41", length = 50)
    private String featSwCombo41 = "";

    @Column(name = "feat_sw_c42", length = 50)
    private String featSwCombo42 = "";

    @Column(name = "feat_sw_cb4")
    private Boolean featSwCB4 = false;

    @Column(name = "feat_sw_f4", length = 150)
    private String featSwField4 = "";

    @Column(name = "feat_sw_c51", length = 50)
    private String featSwCombo51 = "";

    @Column(name = "feat_sw_c52", length = 50)
    private String featSwCombo52 = "";

    @Column(name = "feat_sw_cb5")
    private Boolean featSwCB5 = false;

    @Column(name = "feat_sw_f5", length = 150)
    private String featSwField5 = "";

    @Column(name = "hw_device_c11", length = 50)
    private String hardwareDeviceCombo11 = "";

    @Column(name = "hw_device_c12", length = 50)
    private String hardwareDeviceCombo12 = "";

    @Column(name = "hw_device_c13", length = 50)
    private String hardwareDeviceCombo13 = "";

    @Column(name = "hw_device_cb1")
    private Boolean hardwareDeviceCB1 = false;

    @Column(name = "hw_device_f1", length = 150)
    private String hardwareDeviceField1 = "";

    @Column(name = "hw_device_c21", length = 50)
    private String hardwareDeviceCombo21 = "";

    @Column(name = "hw_device_c22", length = 50)
    private String hardwareDeviceCombo22 = "";

    @Column(name = "hw_device_c23", length = 50)
    private String hardwareDeviceCombo23 = "";

    @Column(name = "hw_device_cb2")
    private Boolean hardwareDeviceCB2 = false;

    @Column(name = "hw_device_f2", length = 150)
    private String hardwareDeviceField2 = "";

    @Column(name = "hw_device_c31", length = 50)
    private String hardwareDeviceCombo31 = "";

    @Column(name = "hw_device_c32", length = 50)
    private String hardwareDeviceCombo32 = "";

    @Column(name = "hw_device_c33", length = 50)
    private String hardwareDeviceCombo33 = "";

    @Column(name = "hw_device_cb3")
    private Boolean hardwareDeviceCB3 = false;

    @Column(name = "hw_device_f3", length = 150)
    private String hardwareDeviceField3 = "";

    @Column(name = "hw_device_c41", length = 50)
    private String hardwareDeviceCombo41 = "";

    @Column(name = "hw_device_c42", length = 50)
    private String hardwareDeviceCombo42 = "";

    @Column(name = "hw_device_c43", length = 50)
    private String hardwareDeviceCombo43 = "";

    @Column(name = "hw_device_cb4")
    private Boolean hardwareDeviceCB4 = false;

    @Column(name = "hw_device_f4", length = 150)
    private String hardwareDeviceField4 = "";

    @Column(name = "hw_device_c51", length = 50)
    private String hardwareDeviceCombo51 = "";

    @Column(name = "hw_device_c52", length = 50)
    private String hardwareDeviceCombo52 = "";

    @Column(name = "hw_device_c53", length = 50)
    private String hardwareDeviceCombo53 = "";

    @Column(name = "hw_device_cb5")
    private Boolean hardwareDeviceCB5 = false;

    @Column(name = "hw_device_f5", length = 150)
    private String hardwareDeviceField5 = "";

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the user
     */
    public User getUser() {
	return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
	this.user = user;
    }

    /**
     * @return the comboboxes
     */
    public static Map<String, Map> getComboboxes() {
	return comboboxes;
    }

    /**
     * @return the terminalCombo11
     */
    public String getTerminalCombo11() {
	return terminalCombo11;
    }

    /**
     * @return the terminalCombo12
     */
    public String getTerminalCombo12() {
	return terminalCombo12;
    }

    /**
     * @return the terminalField1
     */
    public String getTerminalField1() {
	return terminalField1;
    }

    /**
     * @param terminalCombo11
     *            the terminalCombo11 to set
     */
    public void setTerminalCombo11(String terminalCombo11) {
	this.terminalCombo11 = terminalCombo11;
    }

    /**
     * @param terminalCombo12
     *            the terminalCombo12 to set
     */
    public void setTerminalCombo12(String terminalCombo12) {
	this.terminalCombo12 = terminalCombo12;
    }

    /**
     * @param terminalField1
     *            the terminalField1 to set
     */
    public void setTerminalField1(String terminalField1) {
	this.terminalField1 = terminalField1;
    }

    /**
     * @return the terminalCombo21
     */
    public String getTerminalCombo21() {
	return terminalCombo21;
    }

    /**
     * @return the terminalCombo22
     */
    public String getTerminalCombo22() {
	return terminalCombo22;
    }

    /**
     * @return the terminalField2
     */
    public String getTerminalField2() {
	return terminalField2;
    }

    /**
     * @return the terminalCombo31
     */
    public String getTerminalCombo31() {
	return terminalCombo31;
    }

    /**
     * @return the terminalCombo32
     */
    public String getTerminalCombo32() {
	return terminalCombo32;
    }

    /**
     * @return the terminalField3
     */
    public String getTerminalField3() {
	return terminalField3;
    }

    /**
     * @return the terminalCombo41
     */
    public String getTerminalCombo41() {
	return terminalCombo41;
    }

    /**
     * @return the terminalCombo42
     */
    public String getTerminalCombo42() {
	return terminalCombo42;
    }

    /**
     * @return the terminalField4
     */
    public String getTerminalField4() {
	return terminalField4;
    }

    /**
     * @return the terminalCombo51
     */
    public String getTerminalCombo51() {
	return terminalCombo51;
    }

    /**
     * @return the terminalCombo52
     */
    public String getTerminalCombo52() {
	return terminalCombo52;
    }

    /**
     * @return the terminalField5
     */
    public String getTerminalField5() {
	return terminalField5;
    }

    /**
     * @param terminalCombo21
     *            the terminalCombo21 to set
     */
    public void setTerminalCombo21(String terminalCombo21) {
	this.terminalCombo21 = terminalCombo21;
    }

    /**
     * @param terminalCombo22
     *            the terminalCombo22 to set
     */
    public void setTerminalCombo22(String terminalCombo22) {
	this.terminalCombo22 = terminalCombo22;
    }

    /**
     * @param terminalField2
     *            the terminalField2 to set
     */
    public void setTerminalField2(String terminalField2) {
	this.terminalField2 = terminalField2;
    }

    /**
     * @param terminalCombo31
     *            the terminalCombo31 to set
     */
    public void setTerminalCombo31(String terminalCombo31) {
	this.terminalCombo31 = terminalCombo31;
    }

    /**
     * @param terminalCombo32
     *            the terminalCombo32 to set
     */
    public void setTerminalCombo32(String terminalCombo32) {
	this.terminalCombo32 = terminalCombo32;
    }

    /**
     * @param terminalField3
     *            the terminalField3 to set
     */
    public void setTerminalField3(String terminalField3) {
	this.terminalField3 = terminalField3;
    }

    /**
     * @param terminalCombo41
     *            the terminalCombo41 to set
     */
    public void setTerminalCombo41(String terminalCombo41) {
	this.terminalCombo41 = terminalCombo41;
    }

    /**
     * @param terminalCombo42
     *            the terminalCombo42 to set
     */
    public void setTerminalCombo42(String terminalCombo42) {
	this.terminalCombo42 = terminalCombo42;
    }

    /**
     * @param terminalField4
     *            the terminalField4 to set
     */
    public void setTerminalField4(String terminalField4) {
	this.terminalField4 = terminalField4;
    }

    /**
     * @param terminalCombo51
     *            the terminalCombo51 to set
     */
    public void setTerminalCombo51(String terminalCombo51) {
	this.terminalCombo51 = terminalCombo51;
    }

    /**
     * @param terminalCombo52
     *            the terminalCombo52 to set
     */
    public void setTerminalCombo52(String terminalCombo52) {
	this.terminalCombo52 = terminalCombo52;
    }

    /**
     * @param terminalField5
     *            the terminalField5 to set
     */
    public void setTerminalField5(String terminalField5) {
	this.terminalField5 = terminalField5;
    }

    /**
     * @return the terminalCB1
     */
    public Boolean getTerminalCB1() {
	return terminalCB1;
    }

    /**
     * @return the terminalCB2
     */
    public Boolean getTerminalCB2() {
	return terminalCB2;
    }

    /**
     * @return the terminalCB3
     */
    public Boolean getTerminalCB3() {
	return terminalCB3;
    }

    /**
     * @return the terminalCB4
     */
    public Boolean getTerminalCB4() {
	return terminalCB4;
    }

    /**
     * @return the terminalCB5
     */
    public Boolean getTerminalCB5() {
	return terminalCB5;
    }

    /**
     * @param terminalCB1
     *            the terminalCB1 to set
     */
    public void setTerminalCB1(Boolean terminalCB1) {
	this.terminalCB1 = terminalCB1;
    }

    /**
     * @param terminalCB2
     *            the terminalCB2 to set
     */
    public void setTerminalCB2(Boolean terminalCB2) {
	this.terminalCB2 = terminalCB2;
    }

    /**
     * @param terminalCB3
     *            the terminalCB3 to set
     */
    public void setTerminalCB3(Boolean terminalCB3) {
	this.terminalCB3 = terminalCB3;
    }

    /**
     * @param terminalCB4
     *            the terminalCB4 to set
     */
    public void setTerminalCB4(Boolean terminalCB4) {
	this.terminalCB4 = terminalCB4;
    }

    /**
     * @param terminalCB5
     *            the terminalCB5 to set
     */
    public void setTerminalCB5(Boolean terminalCB5) {
	this.terminalCB5 = terminalCB5;
    }

    private String getTerminalConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("terminal." + terminalCombo11,
		terminalCombo12, terminalField1, terminalCB1, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo21,
		terminalCombo22, terminalField2, terminalCB2, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo31,
		terminalCombo32, terminalField3, terminalCB3, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo41,
		terminalCombo42, terminalField4, terminalCB4, values, types,
		locale);
	constraints += getConstraint("terminal." + terminalCombo51,
		terminalCombo52, terminalField5, terminalCB5, values, types,
		locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * @return the financialDeviceCombo11
     */
    public String getFinancialDeviceCombo11() {
	return financialDeviceCombo11;
    }

    /**
     * @return the financialDeviceCombo12
     */
    public String getFinancialDeviceCombo12() {
	return financialDeviceCombo12;
    }

    /**
     * @return the financialDeviceCB1
     */
    public Boolean getFinancialDeviceCB1() {
	return financialDeviceCB1;
    }

    /**
     * @return the financialDeviceField1
     */
    public String getFinancialDeviceField1() {
	return financialDeviceField1;
    }

    /**
     * @return the financialDeviceCombo21
     */
    public String getFinancialDeviceCombo21() {
	return financialDeviceCombo21;
    }

    /**
     * @return the financialDeviceCombo22
     */
    public String getFinancialDeviceCombo22() {
	return financialDeviceCombo22;
    }

    /**
     * @return the financialDeviceCB2
     */
    public Boolean getFinancialDeviceCB2() {
	return financialDeviceCB2;
    }

    /**
     * @return the financialDeviceField2
     */
    public String getFinancialDeviceField2() {
	return financialDeviceField2;
    }

    /**
     * @return the financialDeviceCombo31
     */
    public String getFinancialDeviceCombo31() {
	return financialDeviceCombo31;
    }

    /**
     * @return the financialDeviceCombo32
     */
    public String getFinancialDeviceCombo32() {
	return financialDeviceCombo32;
    }

    /**
     * @return the financialDeviceCB3
     */
    public Boolean getFinancialDeviceCB3() {
	return financialDeviceCB3;
    }

    /**
     * @return the financialDeviceField3
     */
    public String getFinancialDeviceField3() {
	return financialDeviceField3;
    }

    /**
     * @return the financialDeviceCombo41
     */
    public String getFinancialDeviceCombo41() {
	return financialDeviceCombo41;
    }

    /**
     * @return the financialDeviceCombo42
     */
    public String getFinancialDeviceCombo42() {
	return financialDeviceCombo42;
    }

    /**
     * @return the financialDeviceCB4
     */
    public Boolean getFinancialDeviceCB4() {
	return financialDeviceCB4;
    }

    /**
     * @return the financialDeviceField4
     */
    public String getFinancialDeviceField4() {
	return financialDeviceField4;
    }

    /**
     * @return the financialDeviceCombo51
     */
    public String getFinancialDeviceCombo51() {
	return financialDeviceCombo51;
    }

    /**
     * @return the financialDeviceCombo52
     */
    public String getFinancialDeviceCombo52() {
	return financialDeviceCombo52;
    }

    /**
     * @return the financialDeviceCB5
     */
    public Boolean getFinancialDeviceCB5() {
	return financialDeviceCB5;
    }

    /**
     * @return the financialDeviceField5
     */
    public String getFinancialDeviceField5() {
	return financialDeviceField5;
    }

    /**
     * @param financialDeviceCombo11
     *            the financialDeviceCombo11 to set
     */
    public void setFinancialDeviceCombo11(String financialDeviceCombo11) {
	this.financialDeviceCombo11 = financialDeviceCombo11;
    }

    /**
     * @param financialDeviceCombo12
     *            the financialDeviceCombo12 to set
     */
    public void setFinancialDeviceCombo12(String financialDeviceCombo12) {
	this.financialDeviceCombo12 = financialDeviceCombo12;
    }

    /**
     * @param financialDeviceCB1
     *            the financialDeviceCB1 to set
     */
    public void setFinancialDeviceCB1(Boolean financialDeviceCB1) {
	this.financialDeviceCB1 = financialDeviceCB1;
    }

    /**
     * @param financialDeviceField1
     *            the financialDeviceField1 to set
     */
    public void setFinancialDeviceField1(String financialDeviceField1) {
	this.financialDeviceField1 = financialDeviceField1;
    }

    /**
     * @param financialDeviceCombo21
     *            the financialDeviceCombo21 to set
     */
    public void setFinancialDeviceCombo21(String financialDeviceCombo21) {
	this.financialDeviceCombo21 = financialDeviceCombo21;
    }

    /**
     * @param financialDeviceCombo22
     *            the financialDeviceCombo22 to set
     */
    public void setFinancialDeviceCombo22(String financialDeviceCombo22) {
	this.financialDeviceCombo22 = financialDeviceCombo22;
    }

    /**
     * @param financialDeviceCB2
     *            the financialDeviceCB2 to set
     */
    public void setFinancialDeviceCB2(Boolean financialDeviceCB2) {
	this.financialDeviceCB2 = financialDeviceCB2;
    }

    /**
     * @param financialDeviceField2
     *            the financialDeviceField2 to set
     */
    public void setFinancialDeviceField2(String financialDeviceField2) {
	this.financialDeviceField2 = financialDeviceField2;
    }

    /**
     * @param financialDeviceCombo31
     *            the financialDeviceCombo31 to set
     */
    public void setFinancialDeviceCombo31(String financialDeviceCombo31) {
	this.financialDeviceCombo31 = financialDeviceCombo31;
    }

    /**
     * @param financialDeviceCombo32
     *            the financialDeviceCombo32 to set
     */
    public void setFinancialDeviceCombo32(String financialDeviceCombo32) {
	this.financialDeviceCombo32 = financialDeviceCombo32;
    }

    /**
     * @param financialDeviceCB3
     *            the financialDeviceCB3 to set
     */
    public void setFinancialDeviceCB3(Boolean financialDeviceCB3) {
	this.financialDeviceCB3 = financialDeviceCB3;
    }

    /**
     * @param financialDeviceField3
     *            the financialDeviceField3 to set
     */
    public void setFinancialDeviceField3(String financialDeviceField3) {
	this.financialDeviceField3 = financialDeviceField3;
    }

    /**
     * @param financialDeviceCombo41
     *            the financialDeviceCombo41 to set
     */
    public void setFinancialDeviceCombo41(String financialDeviceCombo41) {
	this.financialDeviceCombo41 = financialDeviceCombo41;
    }

    /**
     * @param financialDeviceCombo42
     *            the financialDeviceCombo42 to set
     */
    public void setFinancialDeviceCombo42(String financialDeviceCombo42) {
	this.financialDeviceCombo42 = financialDeviceCombo42;
    }

    /**
     * @param financialDeviceCB4
     *            the financialDeviceCB4 to set
     */
    public void setFinancialDeviceCB4(Boolean financialDeviceCB4) {
	this.financialDeviceCB4 = financialDeviceCB4;
    }

    /**
     * @param financialDeviceField4
     *            the financialDeviceField4 to set
     */
    public void setFinancialDeviceField4(String financialDeviceField4) {
	this.financialDeviceField4 = financialDeviceField4;
    }

    /**
     * @param financialDeviceCombo51
     *            the financialDeviceCombo51 to set
     */
    public void setFinancialDeviceCombo51(String financialDeviceCombo51) {
	this.financialDeviceCombo51 = financialDeviceCombo51;
    }

    /**
     * @param financialDeviceCombo52
     *            the financialDeviceCombo52 to set
     */
    public void setFinancialDeviceCombo52(String financialDeviceCombo52) {
	this.financialDeviceCombo52 = financialDeviceCombo52;
    }

    /**
     * @param financialDeviceCB5
     *            the financialDeviceCB5 to set
     */
    public void setFinancialDeviceCB5(Boolean financialDeviceCB5) {
	this.financialDeviceCB5 = financialDeviceCB5;
    }

    /**
     * @param financialDeviceField5
     *            the financialDeviceField5 to set
     */
    public void setFinancialDeviceField5(String financialDeviceField5) {
	this.financialDeviceField5 = financialDeviceField5;
    }

    private String getFinancialDeviceConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo11, financialDeviceCombo12,
		financialDeviceField1, financialDeviceCB1, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo21, financialDeviceCombo22,
		financialDeviceField2, financialDeviceCB2, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo31, financialDeviceCombo32,
		financialDeviceField3, financialDeviceCB3, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo41, financialDeviceCombo42,
		financialDeviceField4, financialDeviceCB4, values, types,
		locale);
	constraints += getConstraint("financialDevice."
		+ financialDeviceCombo51, financialDeviceCombo52,
		financialDeviceField5, financialDeviceCB5, values, types,
		locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * @return the hotfixCombo11
     */
    public String getHotfixCombo11() {
	return hotfixCombo11;
    }

    /**
     * @param hotfixCombo11
     *            the hotfixCombo11 to set
     */
    public void setHotfixCombo11(String hotfixCombo11) {
	this.hotfixCombo11 = hotfixCombo11;
    }

    /**
     * @return the hotfixCombo12
     */
    public String getHotfixCombo12() {
	return hotfixCombo12;
    }

    /**
     * @param hotfixCombo12
     *            the hotfixCombo12 to set
     */
    public void setHotfixCombo12(String hotfixCombo12) {
	this.hotfixCombo12 = hotfixCombo12;
    }

    /**
     * @return the hotfixCB1
     */
    public Boolean getHotfixCB1() {
	return hotfixCB1;
    }

    /**
     * @param hotfixCB1
     *            the hotfixCB1 to set
     */
    public void setHotfixCB1(Boolean hotfixCB1) {
	this.hotfixCB1 = hotfixCB1;
    }

    /**
     * @return the hotfixField1
     */
    public String getHotfixField1() {
	return hotfixField1;
    }

    /**
     * @param hotfixField1
     *            the hotfixField1 to set
     */
    public void setHotfixField1(String hotfixField1) {
	this.hotfixField1 = hotfixField1;
    }

    /**
     * @return the hotfixCombo21
     */
    public String getHotfixCombo21() {
	return hotfixCombo21;
    }

    /**
     * @param hotfixCombo21
     *            the hotfixCombo21 to set
     */
    public void setHotfixCombo21(String hotfixCombo21) {
	this.hotfixCombo21 = hotfixCombo21;
    }

    /**
     * @return the hotfixCombo22
     */
    public String getHotfixCombo22() {
	return hotfixCombo22;
    }

    /**
     * @param hotfixCombo22
     *            the hotfixCombo22 to set
     */
    public void setHotfixCombo22(String hotfixCombo22) {
	this.hotfixCombo22 = hotfixCombo22;
    }

    /**
     * @return the hotfixCB2
     */
    public Boolean getHotfixCB2() {
	return hotfixCB2;
    }

    /**
     * @param hotfixCB2
     *            the hotfixCB2 to set
     */
    public void setHotfixCB2(Boolean hotfixCB2) {
	this.hotfixCB2 = hotfixCB2;
    }

    /**
     * @return the hotfixField2
     */
    public String getHotfixField2() {
	return hotfixField2;
    }

    /**
     * @param hotfixField2
     *            the hotfixField2 to set
     */
    public void setHotfixField2(String hotfixField2) {
	this.hotfixField2 = hotfixField2;
    }

    /**
     * @return the hotfixCombo31
     */
    public String getHotfixCombo31() {
	return hotfixCombo31;
    }

    /**
     * @param hotfixCombo31
     *            the hotfixCombo31 to set
     */
    public void setHotfixCombo31(String hotfixCombo31) {
	this.hotfixCombo31 = hotfixCombo31;
    }

    /**
     * @return the hotfixCombo32
     */
    public String getHotfixCombo32() {
	return hotfixCombo32;
    }

    /**
     * @param hotfixCombo32
     *            the hotfixCombo32 to set
     */
    public void setHotfixCombo32(String hotfixCombo32) {
	this.hotfixCombo32 = hotfixCombo32;
    }

    /**
     * @return the hotfixCB3
     */
    public Boolean getHotfixCB3() {
	return hotfixCB3;
    }

    /**
     * @param hotfixCB3
     *            the hotfixCB3 to set
     */
    public void setHotfixCB3(Boolean hotfixCB3) {
	this.hotfixCB3 = hotfixCB3;
    }

    /**
     * @return the hotfixField3
     */
    public String getHotfixField3() {
	return hotfixField3;
    }

    /**
     * @param hotfixField3
     *            the hotfixField3 to set
     */
    public void setHotfixField3(String hotfixField3) {
	this.hotfixField3 = hotfixField3;
    }

    /**
     * @return the hotfixCombo41
     */
    public String getHotfixCombo41() {
	return hotfixCombo41;
    }

    /**
     * @param hotfixCombo41
     *            the hotfixCombo41 to set
     */
    public void setHotfixCombo41(String hotfixCombo41) {
	this.hotfixCombo41 = hotfixCombo41;
    }

    /**
     * @return the hotfixCombo42
     */
    public String getHotfixCombo42() {
	return hotfixCombo42;
    }

    /**
     * @param hotfixCombo42
     *            the hotfixCombo42 to set
     */
    public void setHotfixCombo42(String hotfixCombo42) {
	this.hotfixCombo42 = hotfixCombo42;
    }

    /**
     * @return the hotfixCB4
     */
    public Boolean getHotfixCB4() {
	return hotfixCB4;
    }

    /**
     * @param hotfixCB4
     *            the hotfixCB4 to set
     */
    public void setHotfixCB4(Boolean hotfixCB4) {
	this.hotfixCB4 = hotfixCB4;
    }

    /**
     * @return the hotfixField4
     */
    public String getHotfixField4() {
	return hotfixField4;
    }

    /**
     * @param hotfixField4
     *            the hotfixField4 to set
     */
    public void setHotfixField4(String hotfixField4) {
	this.hotfixField4 = hotfixField4;
    }

    /**
     * @return the hotfixCombo51
     */
    public String getHotfixCombo51() {
	return hotfixCombo51;
    }

    /**
     * @param hotfixCombo51
     *            the hotfixCombo51 to set
     */
    public void setHotfixCombo51(String hotfixCombo51) {
	this.hotfixCombo51 = hotfixCombo51;
    }

    /**
     * @return the hotfixCombo52
     */
    public String getHotfixCombo52() {
	return hotfixCombo52;
    }

    /**
     * @param hotfixCombo52
     *            the hotfixCombo52 to set
     */
    public void setHotfixCombo52(String hotfixCombo52) {
	this.hotfixCombo52 = hotfixCombo52;
    }

    /**
     * @return the hotfixCB5
     */
    public Boolean getHotfixCB5() {
	return hotfixCB5;
    }

    /**
     * @param hotfixCB5
     *            the hotfixCB5 to set
     */
    public void setHotfixCB5(Boolean hotfixCB5) {
	this.hotfixCB5 = hotfixCB5;
    }

    /**
     * @return the hotfixField5
     */
    public String getHotfixField5() {
	return hotfixField5;
    }

    /**
     * @param hotfixField5
     *            the hotfixField5 to set
     */
    public void setHotfixField5(String hotfixField5) {
	this.hotfixField5 = hotfixField5;
    }

    private String getHotfixConstraints(List<Object> values, List<Type> types,
	    Locale locale) {
	String constraints = "";
	constraints += getConstraint("hotfix." + hotfixCombo11, hotfixCombo12,
		hotfixField1, hotfixCB1, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo21, hotfixCombo22,
		hotfixField2, hotfixCB2, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo31, hotfixCombo32,
		hotfixField3, hotfixCB3, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo41, hotfixCombo42,
		hotfixField4, hotfixCB4, values, types, locale);
	constraints += getConstraint("hotfix." + hotfixCombo51, hotfixCombo52,
		hotfixField5, hotfixCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * @return the internetExplorerCombo11
     */
    public String getInternetExplorerCombo11() {
	return internetExplorerCombo11;
    }

    /**
     * @param internetExplorerCombo11
     *            the internetExplorerCombo11 to set
     */
    public void setInternetExplorerCombo11(String internetExplorerCombo11) {
	this.internetExplorerCombo11 = internetExplorerCombo11;
    }

    /**
     * @return the internetExplorerCombo12
     */
    public String getInternetExplorerCombo12() {
	return internetExplorerCombo12;
    }

    /**
     * @param internetExplorerCombo12
     *            the internetExplorerCombo12 to set
     */
    public void setInternetExplorerCombo12(String internetExplorerCombo12) {
	this.internetExplorerCombo12 = internetExplorerCombo12;
    }

    /**
     * @return the internetExplorerCB1
     */
    public Boolean getInternetExplorerCB1() {
	return internetExplorerCB1;
    }

    /**
     * @param internetExplorerCB1
     *            the internetExplorerCB1 to set
     */
    public void setInternetExplorerCB1(Boolean internetExplorerCB1) {
	this.internetExplorerCB1 = internetExplorerCB1;
    }

    /**
     * @return the internetExplorerField1
     */
    public String getInternetExplorerField1() {
	return internetExplorerField1;
    }

    /**
     * @param internetExplorerField1
     *            the internetExplorerField1 to set
     */
    public void setInternetExplorerField1(String internetExplorerField1) {
	this.internetExplorerField1 = internetExplorerField1;
    }

    /**
     * @return the internetExplorerCombo21
     */
    public String getInternetExplorerCombo21() {
	return internetExplorerCombo21;
    }

    /**
     * @param internetExplorerCombo21
     *            the internetExplorerCombo21 to set
     */
    public void setInternetExplorerCombo21(String internetExplorerCombo21) {
	this.internetExplorerCombo21 = internetExplorerCombo21;
    }

    /**
     * @return the internetExplorerCombo22
     */
    public String getInternetExplorerCombo22() {
	return internetExplorerCombo22;
    }

    /**
     * @param internetExplorerCombo22
     *            the internetExplorerCombo22 to set
     */
    public void setInternetExplorerCombo22(String internetExplorerCombo22) {
	this.internetExplorerCombo22 = internetExplorerCombo22;
    }

    /**
     * @return the internetExplorerCB2
     */
    public Boolean getInternetExplorerCB2() {
	return internetExplorerCB2;
    }

    /**
     * @param internetExplorerCB2
     *            the internetExplorerCB2 to set
     */
    public void setInternetExplorerCB2(Boolean internetExplorerCB2) {
	this.internetExplorerCB2 = internetExplorerCB2;
    }

    /**
     * @return the internetExplorerField2
     */
    public String getInternetExplorerField2() {
	return internetExplorerField2;
    }

    /**
     * @param internetExplorerField2
     *            the internetExplorerField2 to set
     */
    public void setInternetExplorerField2(String internetExplorerField2) {
	this.internetExplorerField2 = internetExplorerField2;
    }

    private String getInternetExplorerConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("internetExplorer."
		+ internetExplorerCombo11, internetExplorerCombo12,
		internetExplorerField1, internetExplorerCB1, values, types,
		locale);
	constraints += getConstraint("internetExplorer."
		+ internetExplorerCombo21, internetExplorerCombo22,
		internetExplorerField2, internetExplorerCB2, values, types,
		locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * @return the operatingSystemCombo11
     */
    public String getOperatingSystemCombo11() {
	return operatingSystemCombo11;
    }

    /**
     * @param operatingSystemCombo11
     *            the operatingSystemCombo11 to set
     */
    public void setOperatingSystemCombo11(String operatingSystemCombo11) {
	this.operatingSystemCombo11 = operatingSystemCombo11;
    }

    /**
     * @return the operatingSystemCombo12
     */
    public String getOperatingSystemCombo12() {
	return operatingSystemCombo12;
    }

    /**
     * @param operatingSystemCombo12
     *            the operatingSystemCombo12 to set
     */
    public void setOperatingSystemCombo12(String operatingSystemCombo12) {
	this.operatingSystemCombo12 = operatingSystemCombo12;
    }

    /**
     * @return the operatingSystemCB1
     */
    public Boolean getOperatingSystemCB1() {
	return operatingSystemCB1;
    }

    /**
     * @param operatingSystemCB1
     *            the operatingSystemCB1 to set
     */
    public void setOperatingSystemCB1(Boolean operatingSystemCB1) {
	this.operatingSystemCB1 = operatingSystemCB1;
    }

    /**
     * @return the operatingSystemField1
     */
    public String getOperatingSystemField1() {
	return operatingSystemField1;
    }

    /**
     * @param operatingSystemField1
     *            the operatingSystemField1 to set
     */
    public void setOperatingSystemField1(String operatingSystemField1) {
	this.operatingSystemField1 = operatingSystemField1;
    }

    /**
     * @return the operatingSystemCombo21
     */
    public String getOperatingSystemCombo21() {
	return operatingSystemCombo21;
    }

    /**
     * @param operatingSystemCombo21
     *            the operatingSystemCombo21 to set
     */
    public void setOperatingSystemCombo21(String operatingSystemCombo21) {
	this.operatingSystemCombo21 = operatingSystemCombo21;
    }

    /**
     * @return the operatingSystemCombo22
     */
    public String getOperatingSystemCombo22() {
	return operatingSystemCombo22;
    }

    /**
     * @param operatingSystemCombo22
     *            the operatingSystemCombo22 to set
     */
    public void setOperatingSystemCombo22(String operatingSystemCombo22) {
	this.operatingSystemCombo22 = operatingSystemCombo22;
    }

    /**
     * @return the operatingSystemCB2
     */
    public Boolean getOperatingSystemCB2() {
	return operatingSystemCB2;
    }

    /**
     * @param operatingSystemCB2
     *            the operatingSystemCB2 to set
     */
    public void setOperatingSystemCB2(Boolean operatingSystemCB2) {
	this.operatingSystemCB2 = operatingSystemCB2;
    }

    /**
     * @return the operatingSystemField2
     */
    public String getOperatingSystemField2() {
	return operatingSystemField2;
    }

    /**
     * @param operatingSystemField2
     *            the operatingSystemField2 to set
     */
    public void setOperatingSystemField2(String operatingSystemField2) {
	this.operatingSystemField2 = operatingSystemField2;
    }

    /**
     * @return the operatingSystemCombo31
     */
    public String getOperatingSystemCombo31() {
	return operatingSystemCombo31;
    }

    /**
     * @param operatingSystemCombo31
     *            the operatingSystemCombo31 to set
     */
    public void setOperatingSystemCombo31(String operatingSystemCombo31) {
	this.operatingSystemCombo31 = operatingSystemCombo31;
    }

    /**
     * @return the operatingSystemCombo32
     */
    public String getOperatingSystemCombo32() {
	return operatingSystemCombo32;
    }

    /**
     * @param operatingSystemCombo32
     *            the operatingSystemCombo32 to set
     */
    public void setOperatingSystemCombo32(String operatingSystemCombo32) {
	this.operatingSystemCombo32 = operatingSystemCombo32;
    }

    /**
     * @return the operatingSystemCB3
     */
    public Boolean getOperatingSystemCB3() {
	return operatingSystemCB3;
    }

    /**
     * @param operatingSystemCB3
     *            the operatingSystemCB3 to set
     */
    public void setOperatingSystemCB3(Boolean operatingSystemCB3) {
	this.operatingSystemCB3 = operatingSystemCB3;
    }

    /**
     * @return the operatingSystemField3
     */
    public String getOperatingSystemField3() {
	return operatingSystemField3;
    }

    /**
     * @param operatingSystemField3
     *            the operatingSystemField3 to set
     */
    public void setOperatingSystemField3(String operatingSystemField3) {
	this.operatingSystemField3 = operatingSystemField3;
    }

    /**
     * @return the operatingSystemCombo41
     */
    public String getOperatingSystemCombo41() {
	return operatingSystemCombo41;
    }

    /**
     * @param operatingSystemCombo41
     *            the operatingSystemCombo41 to set
     */
    public void setOperatingSystemCombo41(String operatingSystemCombo41) {
	this.operatingSystemCombo41 = operatingSystemCombo41;
    }

    /**
     * @return the operatingSystemCombo42
     */
    public String getOperatingSystemCombo42() {
	return operatingSystemCombo42;
    }

    /**
     * @param operatingSystemCombo42
     *            the operatingSystemCombo42 to set
     */
    public void setOperatingSystemCombo42(String operatingSystemCombo42) {
	this.operatingSystemCombo42 = operatingSystemCombo42;
    }

    /**
     * @return the operatingSystemCB4
     */
    public Boolean getOperatingSystemCB4() {
	return operatingSystemCB4;
    }

    /**
     * @param operatingSystemCB4
     *            the operatingSystemCB4 to set
     */
    public void setOperatingSystemCB4(Boolean operatingSystemCB4) {
	this.operatingSystemCB4 = operatingSystemCB4;
    }

    /**
     * @return the operatingSystemField4
     */
    public String getOperatingSystemField4() {
	return operatingSystemField4;
    }

    /**
     * @param operatingSystemField4
     *            the operatingSystemField4 to set
     */
    public void setOperatingSystemField4(String operatingSystemField4) {
	this.operatingSystemField4 = operatingSystemField4;
    }

    /**
     * @return the operatingSystemCombo51
     */
    public String getOperatingSystemCombo51() {
	return operatingSystemCombo51;
    }

    /**
     * @param operatingSystemCombo51
     *            the operatingSystemCombo51 to set
     */
    public void setOperatingSystemCombo51(String operatingSystemCombo51) {
	this.operatingSystemCombo51 = operatingSystemCombo51;
    }

    /**
     * @return the operatingSystemCombo52
     */
    public String getOperatingSystemCombo52() {
	return operatingSystemCombo52;
    }

    /**
     * @param operatingSystemCombo52
     *            the operatingSystemCombo52 to set
     */
    public void setOperatingSystemCombo52(String operatingSystemCombo52) {
	this.operatingSystemCombo52 = operatingSystemCombo52;
    }

    /**
     * @return the operatingSystemCB5
     */
    public Boolean getOperatingSystemCB5() {
	return operatingSystemCB5;
    }

    /**
     * @param operatingSystemCB5
     *            the operatingSystemCB5 to set
     */
    public void setOperatingSystemCB5(Boolean operatingSystemCB5) {
	this.operatingSystemCB5 = operatingSystemCB5;
    }

    /**
     * @return the operatingSystemField5
     */
    public String getOperatingSystemField5() {
	return operatingSystemField5;
    }

    /**
     * @param operatingSystemField5
     *            the operatingSystemField5 to set
     */
    public void setOperatingSystemField5(String operatingSystemField5) {
	this.operatingSystemField5 = operatingSystemField5;
    }

    private String getOperatingSystemConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("operatingSystem."
		+ operatingSystemCombo11, operatingSystemCombo12,
		operatingSystemField1, operatingSystemCB1, values, types,
		locale);
	constraints += getConstraint("operatingSystem."
		+ operatingSystemCombo21, operatingSystemCombo22,
		operatingSystemField2, operatingSystemCB2, values, types,
		locale);
	constraints += getConstraint("operatingSystem."
		+ operatingSystemCombo31, operatingSystemCombo32,
		operatingSystemField3, operatingSystemCB3, values, types,
		locale);
	constraints += getConstraint("operatingSystem."
		+ operatingSystemCombo41, operatingSystemCombo42,
		operatingSystemField4, operatingSystemCB4, values, types,
		locale);
	constraints += getConstraint("operatingSystem."
		+ operatingSystemCombo51, operatingSystemCombo52,
		operatingSystemField5, operatingSystemCB5, values, types,
		locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	return constraints;
    }

    /**
     * @return the softwareCombo11
     */
    public String getSoftwareCombo11() {
	return softwareCombo11;
    }

    /**
     * @param softwareCombo11
     *            the softwareCombo11 to set
     */
    public void setSoftwareCombo11(String softwareCombo11) {
	this.softwareCombo11 = softwareCombo11;
    }

    /**
     * @return the softwareCombo12
     */
    public String getSoftwareCombo12() {
	return softwareCombo12;
    }

    /**
     * @param softwareCombo12
     *            the softwareCombo12 to set
     */
    public void setSoftwareCombo12(String softwareCombo12) {
	this.softwareCombo12 = softwareCombo12;
    }

    /**
     * @return the softwareCB1
     */
    public Boolean getSoftwareCB1() {
	return softwareCB1;
    }

    /**
     * @param softwareCB1
     *            the softwareCB1 to set
     */
    public void setSoftwareCB1(Boolean softwareCB1) {
	this.softwareCB1 = softwareCB1;
    }

    /**
     * @return the softwareField1
     */
    public String getSoftwareField1() {
	return softwareField1;
    }

    /**
     * @param softwareField1
     *            the softwareField1 to set
     */
    public void setSoftwareField1(String softwareField1) {
	this.softwareField1 = softwareField1;
    }

    /**
     * @return the softwareCombo21
     */
    public String getSoftwareCombo21() {
	return softwareCombo21;
    }

    /**
     * @param softwareCombo21
     *            the softwareCombo21 to set
     */
    public void setSoftwareCombo21(String softwareCombo21) {
	this.softwareCombo21 = softwareCombo21;
    }

    /**
     * @return the softwareCombo22
     */
    public String getSoftwareCombo22() {
	return softwareCombo22;
    }

    /**
     * @param softwareCombo22
     *            the softwareCombo22 to set
     */
    public void setSoftwareCombo22(String softwareCombo22) {
	this.softwareCombo22 = softwareCombo22;
    }

    /**
     * @return the softwareCB2
     */
    public Boolean getSoftwareCB2() {
	return softwareCB2;
    }

    /**
     * @param softwareCB2
     *            the softwareCB2 to set
     */
    public void setSoftwareCB2(Boolean softwareCB2) {
	this.softwareCB2 = softwareCB2;
    }

    /**
     * @return the softwareField2
     */
    public String getSoftwareField2() {
	return softwareField2;
    }

    /**
     * @param softwareField2
     *            the softwareField2 to set
     */
    public void setSoftwareField2(String softwareField2) {
	this.softwareField2 = softwareField2;
    }

    /**
     * @return the softwareCombo31
     */
    public String getSoftwareCombo31() {
	return softwareCombo31;
    }

    /**
     * @param softwareCombo31
     *            the softwareCombo31 to set
     */
    public void setSoftwareCombo31(String softwareCombo31) {
	this.softwareCombo31 = softwareCombo31;
    }

    /**
     * @return the softwareCombo32
     */
    public String getSoftwareCombo32() {
	return softwareCombo32;
    }

    /**
     * @param softwareCombo32
     *            the softwareCombo32 to set
     */
    public void setSoftwareCombo32(String softwareCombo32) {
	this.softwareCombo32 = softwareCombo32;
    }

    /**
     * @return the softwareCB3
     */
    public Boolean getSoftwareCB3() {
	return softwareCB3;
    }

    /**
     * @param softwareCB3
     *            the softwareCB3 to set
     */
    public void setSoftwareCB3(Boolean softwareCB3) {
	this.softwareCB3 = softwareCB3;
    }

    /**
     * @return the softwareField3
     */
    public String getSoftwareField3() {
	return softwareField3;
    }

    /**
     * @param softwareField3
     *            the softwareField3 to set
     */
    public void setSoftwareField3(String softwareField3) {
	this.softwareField3 = softwareField3;
    }

    /**
     * @return the softwareCombo41
     */
    public String getSoftwareCombo41() {
	return softwareCombo41;
    }

    /**
     * @param softwareCombo41
     *            the softwareCombo41 to set
     */
    public void setSoftwareCombo41(String softwareCombo41) {
	this.softwareCombo41 = softwareCombo41;
    }

    /**
     * @return the softwareCombo42
     */
    public String getSoftwareCombo42() {
	return softwareCombo42;
    }

    /**
     * @param softwareCombo42
     *            the softwareCombo42 to set
     */
    public void setSoftwareCombo42(String softwareCombo42) {
	this.softwareCombo42 = softwareCombo42;
    }

    /**
     * @return the softwareCB4
     */
    public Boolean getSoftwareCB4() {
	return softwareCB4;
    }

    /**
     * @param softwareCB4
     *            the softwareCB4 to set
     */
    public void setSoftwareCB4(Boolean softwareCB4) {
	this.softwareCB4 = softwareCB4;
    }

    /**
     * @return the softwareField4
     */
    public String getSoftwareField4() {
	return softwareField4;
    }

    /**
     * @param softwareField4
     *            the softwareField4 to set
     */
    public void setSoftwareField4(String softwareField4) {
	this.softwareField4 = softwareField4;
    }

    /**
     * @return the softwareCombo51
     */
    public String getSoftwareCombo51() {
	return softwareCombo51;
    }

    /**
     * @param softwareCombo51
     *            the softwareCombo51 to set
     */
    public void setSoftwareCombo51(String softwareCombo51) {
	this.softwareCombo51 = softwareCombo51;
    }

    /**
     * @return the softwareCombo52
     */
    public String getSoftwareCombo52() {
	return softwareCombo52;
    }

    /**
     * @param softwareCombo52
     *            the softwareCombo52 to set
     */
    public void setSoftwareCombo52(String softwareCombo52) {
	this.softwareCombo52 = softwareCombo52;
    }

    /**
     * @return the softwareCB5
     */
    public Boolean getSoftwareCB5() {
	return softwareCB5;
    }

    /**
     * @param softwareCB5
     *            the softwareCB5 to set
     */
    public void setSoftwareCB5(Boolean softwareCB5) {
	this.softwareCB5 = softwareCB5;
    }

    /**
     * @return the softwareField5
     */
    public String getSoftwareField5() {
	return softwareField5;
    }

    /**
     * @param softwareField5
     *            the softwareField5 to set
     */
    public void setSoftwareField5(String softwareField5) {
	this.softwareField5 = softwareField5;
    }

    private String getSoftwareConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String constraints = "";
	constraints += getConstraint("sw." + softwareCombo11, softwareCombo12,
		softwareField1, softwareCB1, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo21, softwareCombo22,
		softwareField2, softwareCB2, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo31, softwareCombo32,
		softwareField3, softwareCB3, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo41, softwareCombo42,
		softwareField4, softwareCB4, values, types, locale);
	constraints += getConstraint("sw." + softwareCombo51, softwareCombo52,
		softwareField5, softwareCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	if (constraints.length() > 0) {
	    constraints = "terminal.id in (select distinct swConfig.terminal.id"
		    + " from TerminalConfig swConfig join swConfig.software sw where sw.swType = 'Gen'"
		    + " and swConfig.startDate = (select max(startDate) from TerminalConfig tc "
		    + "where tc.terminal.id = terminal.id) and "
		    + constraints
		    + ")";
	}
	return constraints;
    }

    /**
     * @return the xfsSwCombo11
     */
    public String getXfsSwCombo11() {
	return xfsSwCombo11;
    }

    /**
     * @param xfsSwCombo11
     *            the xfsSwCombo11 to set
     */
    public void setXfsSwCombo11(String xfsSwCombo11) {
	this.xfsSwCombo11 = xfsSwCombo11;
    }

    /**
     * @return the xfsSwCombo12
     */
    public String getXfsSwCombo12() {
	return xfsSwCombo12;
    }

    /**
     * @param xfsSwCombo12
     *            the xfsSwCombo12 to set
     */
    public void setXfsSwCombo12(String xfsSwCombo12) {
	this.xfsSwCombo12 = xfsSwCombo12;
    }

    /**
     * @return the xfsSwCB1
     */
    public Boolean getXfsSwCB1() {
	return xfsSwCB1;
    }

    /**
     * @param xfsSwCB1
     *            the xfsSwCB1 to set
     */
    public void setXfsSwCB1(Boolean xfsSwCB1) {
	this.xfsSwCB1 = xfsSwCB1;
    }

    /**
     * @return the xfsSwField1
     */
    public String getXfsSwField1() {
	return xfsSwField1;
    }

    /**
     * @param xfsSwField1
     *            the xfsSwField1 to set
     */
    public void setXfsSwField1(String xfsSwField1) {
	this.xfsSwField1 = xfsSwField1;
    }

    /**
     * @return the xfsSwCombo21
     */
    public String getXfsSwCombo21() {
	return xfsSwCombo21;
    }

    /**
     * @param xfsSwCombo21
     *            the xfsSwCombo21 to set
     */
    public void setXfsSwCombo21(String xfsSwCombo21) {
	this.xfsSwCombo21 = xfsSwCombo21;
    }

    /**
     * @return the xfsSwCombo22
     */
    public String getXfsSwCombo22() {
	return xfsSwCombo22;
    }

    /**
     * @param xfsSwCombo22
     *            the xfsSwCombo22 to set
     */
    public void setXfsSwCombo22(String xfsSwCombo22) {
	this.xfsSwCombo22 = xfsSwCombo22;
    }

    /**
     * @return the xfsSwCB2
     */
    public Boolean getXfsSwCB2() {
	return xfsSwCB2;
    }

    /**
     * @param xfsSwCB2
     *            the xfsSwCB2 to set
     */
    public void setXfsSwCB2(Boolean xfsSwCB2) {
	this.xfsSwCB2 = xfsSwCB2;
    }

    /**
     * @return the xfsSwField2
     */
    public String getXfsSwField2() {
	return xfsSwField2;
    }

    /**
     * @param xfsSwField2
     *            the xfsSwField2 to set
     */
    public void setXfsSwField2(String xfsSwField2) {
	this.xfsSwField2 = xfsSwField2;
    }

    /**
     * @return the xfsSwCombo31
     */
    public String getXfsSwCombo31() {
	return xfsSwCombo31;
    }

    /**
     * @param xfsSwCombo31
     *            the xfsSwCombo31 to set
     */
    public void setXfsSwCombo31(String xfsSwCombo31) {
	this.xfsSwCombo31 = xfsSwCombo31;
    }

    /**
     * @return the xfsSwCombo32
     */
    public String getXfsSwCombo32() {
	return xfsSwCombo32;
    }

    /**
     * @param xfsSwCombo32
     *            the xfsSwCombo32 to set
     */
    public void setXfsSwCombo32(String xfsSwCombo32) {
	this.xfsSwCombo32 = xfsSwCombo32;
    }

    /**
     * @return the xfsSwCB3
     */
    public Boolean getXfsSwCB3() {
	return xfsSwCB3;
    }

    /**
     * @param xfsSwCB3
     *            the xfsSwCB3 to set
     */
    public void setXfsSwCB3(Boolean xfsSwCB3) {
	this.xfsSwCB3 = xfsSwCB3;
    }

    /**
     * @return the xfsSwField3
     */
    public String getXfsSwField3() {
	return xfsSwField3;
    }

    /**
     * @param xfsSwField3
     *            the xfsSwField3 to set
     */
    public void setXfsSwField3(String xfsSwField3) {
	this.xfsSwField3 = xfsSwField3;
    }

    /**
     * @return the xfsSwCombo41
     */
    public String getXfsSwCombo41() {
	return xfsSwCombo41;
    }

    /**
     * @param xfsSwCombo41
     *            the xfsSwCombo41 to set
     */
    public void setXfsSwCombo41(String xfsSwCombo41) {
	this.xfsSwCombo41 = xfsSwCombo41;
    }

    /**
     * @return the xfsSwCombo42
     */
    public String getXfsSwCombo42() {
	return xfsSwCombo42;
    }

    /**
     * @param xfsSwCombo42
     *            the xfsSwCombo42 to set
     */
    public void setXfsSwCombo42(String xfsSwCombo42) {
	this.xfsSwCombo42 = xfsSwCombo42;
    }

    /**
     * @return the xfsSwCB4
     */
    public Boolean getXfsSwCB4() {
	return xfsSwCB4;
    }

    /**
     * @param xfsSwCB4
     *            the xfsSwCB4 to set
     */
    public void setXfsSwCB4(Boolean xfsSwCB4) {
	this.xfsSwCB4 = xfsSwCB4;
    }

    /**
     * @return the xfsSwField4
     */
    public String getXfsSwField4() {
	return xfsSwField4;
    }

    /**
     * @param xfsSwField4
     *            the xfsSwField4 to set
     */
    public void setXfsSwField4(String xfsSwField4) {
	this.xfsSwField4 = xfsSwField4;
    }

    /**
     * @return the xfsSwCombo51
     */
    public String getXfsSwCombo51() {
	return xfsSwCombo51;
    }

    /**
     * @param xfsSwCombo51
     *            the xfsSwCombo51 to set
     */
    public void setXfsSwCombo51(String xfsSwCombo51) {
	this.xfsSwCombo51 = xfsSwCombo51;
    }

    /**
     * @return the xfsSwCombo52
     */
    public String getXfsSwCombo52() {
	return xfsSwCombo52;
    }

    /**
     * @param xfsSwCombo52
     *            the xfsSwCombo52 to set
     */
    public void setXfsSwCombo52(String xfsSwCombo52) {
	this.xfsSwCombo52 = xfsSwCombo52;
    }

    /**
     * @return the xfsSwCB5
     */
    public Boolean getXfsSwCB5() {
	return xfsSwCB5;
    }

    /**
     * @param xfsSwCB5
     *            the xfsSwCB5 to set
     */
    public void setXfsSwCB5(Boolean xfsSwCB5) {
	this.xfsSwCB5 = xfsSwCB5;
    }

    /**
     * @return the xfsSwField5
     */
    public String getXfsSwField5() {
	return xfsSwField5;
    }

    /**
     * @param xfsSwField5
     *            the xfsSwField5 to set
     */
    public void setXfsSwField5(String xfsSwField5) {
	this.xfsSwField5 = xfsSwField5;
    }

    private String getXfsSwConstraints(List<Object> values, List<Type> types,
	    Locale locale) {
	String constraints = "";
	constraints += getConstraint("sw." + xfsSwCombo11, xfsSwCombo12,
		xfsSwField1, xfsSwCB1, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo21, xfsSwCombo22,
		xfsSwField2, xfsSwCB2, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo31, xfsSwCombo32,
		xfsSwField3, xfsSwCB3, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo41, xfsSwCombo42,
		xfsSwField4, xfsSwCB4, values, types, locale);
	constraints += getConstraint("sw." + xfsSwCombo51, xfsSwCombo52,
		xfsSwField5, xfsSwCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	if (constraints.length() > 0) {
	    constraints = "terminal.id in (select distinct swConfig.terminal.id"
		    + " from TerminalConfig swConfig join swConfig.software sw where sw.swType = 'XFS'"
		    + " and swConfig.startDate = (select max(startDate) from TerminalConfig tc "
		    + "where tc.terminal.id = terminal.id) and "
		    + constraints
		    + ")";
	}
	return constraints;
    }

    /**
     * @return the featSwCombo11
     */
    public String getFeatSwCombo11() {
	return featSwCombo11;
    }

    /**
     * @param featSwCombo11
     *            the featSwCombo11 to set
     */
    public void setFeatSwCombo11(String featSwCombo11) {
	this.featSwCombo11 = featSwCombo11;
    }

    /**
     * @return the featSwCombo12
     */
    public String getFeatSwCombo12() {
	return featSwCombo12;
    }

    /**
     * @param featSwCombo12
     *            the featSwCombo12 to set
     */
    public void setFeatSwCombo12(String featSwCombo12) {
	this.featSwCombo12 = featSwCombo12;
    }

    /**
     * @return the featSwCB1
     */
    public Boolean getFeatSwCB1() {
	return featSwCB1;
    }

    /**
     * @param featSwCB1
     *            the featSwCB1 to set
     */
    public void setFeatSwCB1(Boolean featSwCB1) {
	this.featSwCB1 = featSwCB1;
    }

    /**
     * @return the featSwField1
     */
    public String getFeatSwField1() {
	return featSwField1;
    }

    /**
     * @param featSwField1
     *            the featSwField1 to set
     */
    public void setFeatSwField1(String featSwField1) {
	this.featSwField1 = featSwField1;
    }

    /**
     * @return the featSwCombo21
     */
    public String getFeatSwCombo21() {
	return featSwCombo21;
    }

    /**
     * @param featSwCombo21
     *            the featSwCombo21 to set
     */
    public void setFeatSwCombo21(String featSwCombo21) {
	this.featSwCombo21 = featSwCombo21;
    }

    /**
     * @return the featSwCombo22
     */
    public String getFeatSwCombo22() {
	return featSwCombo22;
    }

    /**
     * @param featSwCombo22
     *            the featSwCombo22 to set
     */
    public void setFeatSwCombo22(String featSwCombo22) {
	this.featSwCombo22 = featSwCombo22;
    }

    /**
     * @return the featSwCB2
     */
    public Boolean getFeatSwCB2() {
	return featSwCB2;
    }

    /**
     * @param featSwCB2
     *            the featSwCB2 to set
     */
    public void setFeatSwCB2(Boolean featSwCB2) {
	this.featSwCB2 = featSwCB2;
    }

    /**
     * @return the featSwField2
     */
    public String getFeatSwField2() {
	return featSwField2;
    }

    /**
     * @param featSwField2
     *            the featSwField2 to set
     */
    public void setFeatSwField2(String featSwField2) {
	this.featSwField2 = featSwField2;
    }

    /**
     * @return the featSwCombo31
     */
    public String getFeatSwCombo31() {
	return featSwCombo31;
    }

    /**
     * @param featSwCombo31
     *            the featSwCombo31 to set
     */
    public void setFeatSwCombo31(String featSwCombo31) {
	this.featSwCombo31 = featSwCombo31;
    }

    /**
     * @return the featSwCombo32
     */
    public String getFeatSwCombo32() {
	return featSwCombo32;
    }

    /**
     * @param featSwCombo32
     *            the featSwCombo32 to set
     */
    public void setFeatSwCombo32(String featSwCombo32) {
	this.featSwCombo32 = featSwCombo32;
    }

    /**
     * @return the featSwCB3
     */
    public Boolean getFeatSwCB3() {
	return featSwCB3;
    }

    /**
     * @param featSwCB3
     *            the featSwCB3 to set
     */
    public void setFeatSwCB3(Boolean featSwCB3) {
	this.featSwCB3 = featSwCB3;
    }

    /**
     * @return the featSwField3
     */
    public String getFeatSwField3() {
	return featSwField3;
    }

    /**
     * @param featSwField3
     *            the featSwField3 to set
     */
    public void setFeatSwField3(String featSwField3) {
	this.featSwField3 = featSwField3;
    }

    /**
     * @return the featSwCombo41
     */
    public String getFeatSwCombo41() {
	return featSwCombo41;
    }

    /**
     * @param featSwCombo41
     *            the featSwCombo41 to set
     */
    public void setFeatSwCombo41(String featSwCombo41) {
	this.featSwCombo41 = featSwCombo41;
    }

    /**
     * @return the featSwCombo42
     */
    public String getFeatSwCombo42() {
	return featSwCombo42;
    }

    /**
     * @param featSwCombo42
     *            the featSwCombo42 to set
     */
    public void setFeatSwCombo42(String featSwCombo42) {
	this.featSwCombo42 = featSwCombo42;
    }

    /**
     * @return the featSwCB4
     */
    public Boolean getFeatSwCB4() {
	return featSwCB4;
    }

    /**
     * @param featSwCB4
     *            the featSwCB4 to set
     */
    public void setFeatSwCB4(Boolean featSwCB4) {
	this.featSwCB4 = featSwCB4;
    }

    /**
     * @return the featSwField4
     */
    public String getFeatSwField4() {
	return featSwField4;
    }

    /**
     * @param featSwField4
     *            the featSwField4 to set
     */
    public void setFeatSwField4(String featSwField4) {
	this.featSwField4 = featSwField4;
    }

    /**
     * @return the featSwCombo51
     */
    public String getFeatSwCombo51() {
	return featSwCombo51;
    }

    /**
     * @param featSwCombo51
     *            the featSwCombo51 to set
     */
    public void setFeatSwCombo51(String featSwCombo51) {
	this.featSwCombo51 = featSwCombo51;
    }

    /**
     * @return the featSwCombo52
     */
    public String getFeatSwCombo52() {
	return featSwCombo52;
    }

    /**
     * @param featSwCombo52
     *            the featSwCombo52 to set
     */
    public void setFeatSwCombo52(String featSwCombo52) {
	this.featSwCombo52 = featSwCombo52;
    }

    /**
     * @return the featSwCB5
     */
    public Boolean getFeatSwCB5() {
	return featSwCB5;
    }

    /**
     * @param featSwCB5
     *            the featSwCB5 to set
     */
    public void setFeatSwCB5(Boolean featSwCB5) {
	this.featSwCB5 = featSwCB5;
    }

    /**
     * @return the featSwField5
     */
    public String getFeatSwField5() {
	return featSwField5;
    }

    /**
     * @param featSwField5
     *            the featSwField5 to set
     */
    public void setFeatSwField5(String featSwField5) {
	this.featSwField5 = featSwField5;
    }

    private String getFeatSwConstraints(List<Object> values, List<Type> types,
	    Locale locale) {
	String constraints = "";
	constraints += getConstraint("sw." + featSwCombo11, featSwCombo12,
		featSwField1, featSwCB1, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo21, featSwCombo22,
		featSwField2, featSwCB2, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo31, featSwCombo32,
		featSwField3, featSwCB3, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo41, featSwCombo42,
		featSwField4, featSwCB4, values, types, locale);
	constraints += getConstraint("sw." + featSwCombo51, featSwCombo52,
		featSwField5, featSwCB5, values, types, locale);
	if (constraints.endsWith(" and ")) {
	    constraints = constraints.substring(0, constraints.length() - 5);
	}
	if (constraints.length() > 0) {
	    constraints = "terminal.id in (select distinct swConfig.terminal.id"
		    + " from TerminalConfig swConfig join swConfig.software sw where sw.swType = 'Feat'"
		    + " and swConfig.startDate = (select max(startDate) from TerminalConfig tc "
		    + "where tc.terminal.id = terminal.id) and "
		    + constraints
		    + ")";
	}
	return constraints;
    }

    /**
     * @return the hardwareDeviceCombo11
     */
    public String getHardwareDeviceCombo11() {
	return hardwareDeviceCombo11;
    }

    /**
     * @param hardwareDeviceCombo11
     *            the hardwareDeviceCombo11 to set
     */
    public void setHardwareDeviceCombo11(String hardwareDeviceCombo11) {
	this.hardwareDeviceCombo11 = hardwareDeviceCombo11;
    }

    /**
     * @return the hardwareDeviceCombo12
     */
    public String getHardwareDeviceCombo12() {
	return hardwareDeviceCombo12;
    }

    /**
     * @param hardwareDeviceCombo12
     *            the hardwareDeviceCombo12 to set
     */
    public void setHardwareDeviceCombo12(String hardwareDeviceCombo12) {
	this.hardwareDeviceCombo12 = hardwareDeviceCombo12;
    }

    /**
     * @return the hardwareDeviceCombo13
     */
    public String getHardwareDeviceCombo13() {
	return hardwareDeviceCombo13;
    }

    /**
     * @param hardwareDeviceCombo13
     *            the hardwareDeviceCombo13 to set
     */
    public void setHardwareDeviceCombo13(String hardwareDeviceCombo13) {
	this.hardwareDeviceCombo13 = hardwareDeviceCombo13;
    }

    /**
     * @return the hardwareDeviceCB1
     */
    public Boolean getHardwareDeviceCB1() {
	return hardwareDeviceCB1;
    }

    /**
     * @param hardwareDeviceCB1
     *            the hardwareDeviceCB1 to set
     */
    public void setHardwareDeviceCB1(Boolean hardwareDeviceCB1) {
	this.hardwareDeviceCB1 = hardwareDeviceCB1;
    }

    /**
     * @return the hardwareDeviceField1
     */
    public String getHardwareDeviceField1() {
	return hardwareDeviceField1;
    }

    /**
     * @param hardwareDeviceField1
     *            the hardwareDeviceField1 to set
     */
    public void setHardwareDeviceField1(String hardwareDeviceField1) {
	this.hardwareDeviceField1 = hardwareDeviceField1;
    }

    /**
     * @return the hardwareDeviceCombo21
     */
    public String getHardwareDeviceCombo21() {
	return hardwareDeviceCombo21;
    }

    /**
     * @param hardwareDeviceCombo21
     *            the hardwareDeviceCombo21 to set
     */
    public void setHardwareDeviceCombo21(String hardwareDeviceCombo21) {
	this.hardwareDeviceCombo21 = hardwareDeviceCombo21;
    }

    /**
     * @return the hardwareDeviceCombo22
     */
    public String getHardwareDeviceCombo22() {
	return hardwareDeviceCombo22;
    }

    /**
     * @param hardwareDeviceCombo22
     *            the hardwareDeviceCombo22 to set
     */
    public void setHardwareDeviceCombo22(String hardwareDeviceCombo22) {
	this.hardwareDeviceCombo22 = hardwareDeviceCombo22;
    }

    /**
     * @return the hardwareDeviceCombo23
     */
    public String getHardwareDeviceCombo23() {
	return hardwareDeviceCombo23;
    }

    /**
     * @param hardwareDeviceCombo23
     *            the hardwareDeviceCombo23 to set
     */
    public void setHardwareDeviceCombo23(String hardwareDeviceCombo23) {
	this.hardwareDeviceCombo23 = hardwareDeviceCombo23;
    }

    /**
     * @return the hardwareDeviceCB2
     */
    public Boolean getHardwareDeviceCB2() {
	return hardwareDeviceCB2;
    }

    /**
     * @param hardwareDeviceCB2
     *            the hardwareDeviceCB2 to set
     */
    public void setHardwareDeviceCB2(Boolean hardwareDeviceCB2) {
	this.hardwareDeviceCB2 = hardwareDeviceCB2;
    }

    /**
     * @return the hardwareDeviceField2
     */
    public String getHardwareDeviceField2() {
	return hardwareDeviceField2;
    }

    /**
     * @param hardwareDeviceField2
     *            the hardwareDeviceField2 to set
     */
    public void setHardwareDeviceField2(String hardwareDeviceField2) {
	this.hardwareDeviceField2 = hardwareDeviceField2;
    }

    /**
     * @return the hardwareDeviceCombo31
     */
    public String getHardwareDeviceCombo31() {
	return hardwareDeviceCombo31;
    }

    /**
     * @param hardwareDeviceCombo31
     *            the hardwareDeviceCombo31 to set
     */
    public void setHardwareDeviceCombo31(String hardwareDeviceCombo31) {
	this.hardwareDeviceCombo31 = hardwareDeviceCombo31;
    }

    /**
     * @return the hardwareDeviceCombo32
     */
    public String getHardwareDeviceCombo32() {
	return hardwareDeviceCombo32;
    }

    /**
     * @param hardwareDeviceCombo32
     *            the hardwareDeviceCombo32 to set
     */
    public void setHardwareDeviceCombo32(String hardwareDeviceCombo32) {
	this.hardwareDeviceCombo32 = hardwareDeviceCombo32;
    }

    /**
     * @return the hardwareDeviceCombo33
     */
    public String getHardwareDeviceCombo33() {
	return hardwareDeviceCombo33;
    }

    /**
     * @param hardwareDeviceCombo33
     *            the hardwareDeviceCombo33 to set
     */
    public void setHardwareDeviceCombo33(String hardwareDeviceCombo33) {
	this.hardwareDeviceCombo33 = hardwareDeviceCombo33;
    }

    /**
     * @return the hardwareDeviceCB3
     */
    public Boolean getHardwareDeviceCB3() {
	return hardwareDeviceCB3;
    }

    /**
     * @param hardwareDeviceCB3
     *            the hardwareDeviceCB3 to set
     */
    public void setHardwareDeviceCB3(Boolean hardwareDeviceCB3) {
	this.hardwareDeviceCB3 = hardwareDeviceCB3;
    }

    /**
     * @return the hardwareDeviceField3
     */
    public String getHardwareDeviceField3() {
	return hardwareDeviceField3;
    }

    /**
     * @param hardwareDeviceField3
     *            the hardwareDeviceField3 to set
     */
    public void setHardwareDeviceField3(String hardwareDeviceField3) {
	this.hardwareDeviceField3 = hardwareDeviceField3;
    }

    /**
     * @return the hardwareDeviceCombo41
     */
    public String getHardwareDeviceCombo41() {
	return hardwareDeviceCombo41;
    }

    /**
     * @param hardwareDeviceCombo41
     *            the hardwareDeviceCombo41 to set
     */
    public void setHardwareDeviceCombo41(String hardwareDeviceCombo41) {
	this.hardwareDeviceCombo41 = hardwareDeviceCombo41;
    }

    /**
     * @return the hardwareDeviceCombo42
     */
    public String getHardwareDeviceCombo42() {
	return hardwareDeviceCombo42;
    }

    /**
     * @param hardwareDeviceCombo42
     *            the hardwareDeviceCombo42 to set
     */
    public void setHardwareDeviceCombo42(String hardwareDeviceCombo42) {
	this.hardwareDeviceCombo42 = hardwareDeviceCombo42;
    }

    /**
     * @return the hardwareDeviceCombo43
     */
    public String getHardwareDeviceCombo43() {
	return hardwareDeviceCombo43;
    }

    /**
     * @param hardwareDeviceCombo43
     *            the hardwareDeviceCombo43 to set
     */
    public void setHardwareDeviceCombo43(String hardwareDeviceCombo43) {
	this.hardwareDeviceCombo43 = hardwareDeviceCombo43;
    }

    /**
     * @return the hardwareDeviceCB4
     */
    public Boolean getHardwareDeviceCB4() {
	return hardwareDeviceCB4;
    }

    /**
     * @param hardwareDeviceCB4
     *            the hardwareDeviceCB4 to set
     */
    public void setHardwareDeviceCB4(Boolean hardwareDeviceCB4) {
	this.hardwareDeviceCB4 = hardwareDeviceCB4;
    }

    /**
     * @return the hardwareDeviceField4
     */
    public String getHardwareDeviceField4() {
	return hardwareDeviceField4;
    }

    /**
     * @param hardwareDeviceField4
     *            the hardwareDeviceField4 to set
     */
    public void setHardwareDeviceField4(String hardwareDeviceField4) {
	this.hardwareDeviceField4 = hardwareDeviceField4;
    }

    /**
     * @return the hardwareDeviceCombo51
     */
    public String getHardwareDeviceCombo51() {
	return hardwareDeviceCombo51;
    }

    /**
     * @param hardwareDeviceCombo51
     *            the hardwareDeviceCombo51 to set
     */
    public void setHardwareDeviceCombo51(String hardwareDeviceCombo51) {
	this.hardwareDeviceCombo51 = hardwareDeviceCombo51;
    }

    /**
     * @return the hardwareDeviceCombo52
     */
    public String getHardwareDeviceCombo52() {
	return hardwareDeviceCombo52;
    }

    /**
     * @param hardwareDeviceCombo52
     *            the hardwareDeviceCombo52 to set
     */
    public void setHardwareDeviceCombo52(String hardwareDeviceCombo52) {
	this.hardwareDeviceCombo52 = hardwareDeviceCombo52;
    }

    /**
     * @return the hardwareDeviceCombo53
     */
    public String getHardwareDeviceCombo53() {
	return hardwareDeviceCombo53;
    }

    /**
     * @param hardwareDeviceCombo53
     *            the hardwareDeviceCombo53 to set
     */
    public void setHardwareDeviceCombo53(String hardwareDeviceCombo53) {
	this.hardwareDeviceCombo53 = hardwareDeviceCombo53;
    }

    /**
     * @return the hardwareDeviceCB5
     */
    public Boolean getHardwareDeviceCB5() {
	return hardwareDeviceCB5;
    }

    /**
     * @param hardwareDeviceCB5
     *            the hardwareDeviceCB5 to set
     */
    public void setHardwareDeviceCB5(Boolean hardwareDeviceCB5) {
	this.hardwareDeviceCB5 = hardwareDeviceCB5;
    }

    /**
     * @return the hardwareDeviceField5
     */
    public String getHardwareDeviceField5() {
	return hardwareDeviceField5;
    }

    /**
     * @param hardwareDeviceField5
     *            the hardwareDeviceField5 to set
     */
    public void setHardwareDeviceField5(String hardwareDeviceField5) {
	this.hardwareDeviceField5 = hardwareDeviceField5;
    }

    private void storeHardwareDeviceConstraint(String deviceClass,
	    String field, String operation, String value, boolean not,
	    Map<String, String> constraints, List<Object> values,
	    List<Type> types, Locale locale) {
	if ((deviceClass != null) && (deviceClass != "")) {
	    String constraint = getConstraint("hardwareDevice." + field,
		    operation, value, not, values, types, locale);
	    if (constraint != "") {
		if (constraints.containsKey(deviceClass)) {
		    constraints.put(deviceClass, constraints.get(deviceClass)
			    + constraint);
		} else {
		    constraints.put(deviceClass, constraint);
		}
	    }
	}
    }

    private String getHardwareDeviceConstraints(List<Object> values,
	    List<Type> types, Locale locale) {
	String globalConstraint = "";
	Map<String, String> constraints = new HashMap<String, String>();
	storeHardwareDeviceConstraint(hardwareDeviceCombo11,
		hardwareDeviceCombo12, hardwareDeviceCombo13,
		hardwareDeviceField1, hardwareDeviceCB1, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo21,
		hardwareDeviceCombo22, hardwareDeviceCombo23,
		hardwareDeviceField2, hardwareDeviceCB2, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo31,
		hardwareDeviceCombo32, hardwareDeviceCombo33,
		hardwareDeviceField3, hardwareDeviceCB3, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo41,
		hardwareDeviceCombo42, hardwareDeviceCombo43,
		hardwareDeviceField4, hardwareDeviceCB4, constraints, values,
		types, locale);
	storeHardwareDeviceConstraint(hardwareDeviceCombo51,
		hardwareDeviceCombo52, hardwareDeviceCombo53,
		hardwareDeviceField5, hardwareDeviceCB5, constraints, values,
		types, locale);
	for (String hwClass : constraints.keySet()) {
	    String classConstraints = constraints.get(hwClass);
	    if (classConstraints.endsWith(" and ")) {
		classConstraints = classConstraints.substring(0,
			classConstraints.length() - 5);
	    }
	    globalConstraint += "terminal.id in (select distinct hardwareDevice.terminal.id"
		    + " from HardwareDevice hardwareDevice where hardwareDevice.hardwareClass = '"
		    + hwClass + "' and " + classConstraints + ") and ";

	}
	if (globalConstraint.endsWith(" and ")) {
	    globalConstraint = globalConstraint.substring(0,
		    globalConstraint.length() - 5);
	}
	return globalConstraint;
    }

    private String getConstraint(String column, String operation, String value,
	    boolean not, List<Object> values, List<Type> types, Locale locale) {
	if (!(column.equals("") || operation.equals("") || (value.equals("") && Operation
		.needsNotVoidValue(operation)))) {
	    String constraint = "("
		    + Operation.getConstraintHQL(column, operation, value,
			    values, types, locale) + ")";
	    if (constraint.length() > 0) {
		if (not) {
		    constraint = "not " + constraint;
		}
		constraint += " and ";
	    }
	    return constraint;
	}
	return "";
    }

    public String getHQLGroupingBy(List<Object> values, List<Type> types, Locale locale, String groupByEntity, String groupByField) {
		StringBuffer hql = new StringBuffer("");
		String groupName = (groupByEntity == null) ?
			"terminals." + groupByField :
			groupByEntity + "." + groupByField;
		hql.append("select new map(" + groupName + " as groupName, count(*) as count) from Terminal terminals");
		if (groupByEntity != null) {
			hql.append(" join terminals." + groupByEntity + " " + groupByEntity);
		}
		hql.append(" where terminals in (");
		hql.append(getHQL(values, types, locale, false, false));
		hql.append(") ");
		hql.append("group by ");
		hql.append(groupName);
		return hql.toString();
	}

    public String getHQL(List<Object> values, List<Type> types, Locale locale) {
		return getHQL(values, types, locale, true, true);
	}

    public String getHQL(List<Object> values, List<Type> types, Locale locale, boolean distinct, boolean order) {
	String hql = "select";
	if (distinct) {
		hql += " distinct";
	}
	hql += " terminal from Terminal terminal";
	String terminalConstraints = getTerminalConstraints(values, types,
		locale);
	String financialDeviceConstraints = getFinancialDeviceConstraints(
		values, types, locale);
	String hotfixConstraints = getHotfixConstraints(values, types, locale);
	String internetExplorerConstraints = getInternetExplorerConstraints(
		values, types, locale);
	String softwareConstraints = getSoftwareConstraints(values, types,
		locale);
	String xfsSwConstraints = getXfsSwConstraints(values, types, locale);
	String featSwConstraints = getFeatSwConstraints(values, types, locale);
	String operatingSystemConstraints = getOperatingSystemConstraints(
		values, types, locale);
	String hardwareDeviceConstraints = getHardwareDeviceConstraints(values,
		types, locale);
	if (financialDeviceConstraints.length() > 0) {
	    hql += " join terminal.financialDevices financialDevice";
	}
	if (hotfixConstraints.length() > 0) {
	    hql += " join terminal.hotfixes hotfix";
	}
	if (internetExplorerConstraints.length() > 0) {
	    hql += " join terminal.internetExplorers internetExplorer";
	}
	if (operatingSystemConstraints.length() > 0) {
	    hql += " join terminal.configs softwareConfig join softwareConfig.operatingSystems operatingSystem";
	}

	hql += " where ";
	if (operatingSystemConstraints.length() > 0) {
	    hql += "softwareConfig.startDate = (select max(startDate) from TerminalConfig tc where tc.terminal.id = terminal.id) and ";
	}
	if (terminalConstraints.length() > 0) {
	    hql += "(" + terminalConstraints + ") and ";
	}
	if (financialDeviceConstraints.length() > 0) {
	    hql += "(" + financialDeviceConstraints + ") and ";
	}
	if (hotfixConstraints.length() > 0) {
	    hql += "(" + hotfixConstraints + ") and ";
	}
	if (internetExplorerConstraints.length() > 0) {
	    hql += "(" + internetExplorerConstraints + ") and ";
	}
	if (softwareConstraints.length() > 0) {
	    hql += "(" + softwareConstraints + ") and ";
	}
	if (xfsSwConstraints.length() > 0) {
	    hql += "(" + xfsSwConstraints + ") and ";
	}
	if (featSwConstraints.length() > 0) {
	    hql += "(" + featSwConstraints + ") and ";
	}
	if (operatingSystemConstraints.length() > 0) {
	    hql += "(" + operatingSystemConstraints + ") and ";
	}
	if (hardwareDeviceConstraints.length() > 0) {
	    hql += "(" + hardwareDeviceConstraints + ") and ";
	}

	if (hql.endsWith(" and ")) {
	    hql = hql.substring(0, hql.length() - 5);
	}
	if (hql.endsWith(" where ")) {
	    hql = hql.substring(0, hql.length() - 7);
	}
	if (order) {
		hql += " order by terminal.serialNumber, terminal.id";
	}
	return hql;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

    public Locale getTrueLocale() {
	String[] localeSplit = locale.split("-");
	if (locale.length() == 2) {
	    return new Locale(localeSplit[0], localeSplit[1]);
	}
	return null;
    }

    public void setTrueLocale(Locale locale) {
	this.locale = locale.getLanguage() + "-" + locale.getCountry();
    }

    public Set<ScheduledUpdate> getScheduledUpdates() {
	return scheduledUpdates;
    }

    public void setScheduledUpdates(Set<ScheduledUpdate> scheduledUpdates) {
	this.scheduledUpdates = scheduledUpdates;
    }

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Query) {
			Query otherQuery = (Query)o;
			return ((otherQuery.getName().equals(getName())) &&
					(otherQuery.getUser().equals(getUser())));
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return getName().hashCode() + 13 * getUser().hashCode();
	}

}

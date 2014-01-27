#!/bin/bash

echo "Welcome to ATMMonitoring's configuration script."
echo ""
echo ""
echo "We will make you some questions in order to make the configuration process easier."
echo ""
echo ""

# In case no war file has been specified as argument, we set the default one
if [[ "$#" -lt 1 ]]; then
	file="ATMMonitoring-1.0.war"
else
	file=$1
fi

# We check if we can access the file in write mode
if [ ! -w $file ]; then
	echo "Can't write the file '"$file"'."
	echo "If the route is wrong, please provide the correct route to the war file as an argument, and check its permissions."
	exit;
fi

# If the temp folder already exists, we delete it
if [ -d .ATM_temp ]; then
	rm -rf .ATM_temp
fi

# We create a temp folder and unpack the .war in it
mkdir .ATM_temp
cd .ATM_temp
jar -xf ../$file

config_file="WEB-INF/classes/config.properties"
db_file="WEB-INF/classes/jdbc.properties"

# Regular expression for numbers
re='^[0-9]+$'

# First we ask for the ATMMonitoring specific parameters
echo ""
while true; do
    read -p "Do you wish to configure ATMMonitoring's internal parameters? " yn
    case $yn in
        [Yy]es ) break;;
        [Nn]o ) break;;
        *) echo "Please answer yes or no.";;
    esac
done

if [ "$yn" == "Yes" ] || [ "$yn" == "yes" ]; then

	while true; do
		read -p "How many terminals do you wish to list per page? [10]: " n_terminals
		if [ -z "$n_terminals" ] ; then
			n_terminals=10; break;
		fi
		if [[ $n_terminals =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done

	while true; do
		read -p "How many users do you wish to list per page? [10]: " n_users
		if [ -z "$n_users" ] ; then
			n_users=10; break;
		fi
		if [[ $n_users =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done

	while true; do
		read -p "How many roles do you wish to list per page? [10]: " n_roles
		if [ -z "$n_roles" ] ; then
			n_roles=10; break;
		fi
		if [[ $n_roles =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done

	while true; do
		read -p "How many queries do you wish to list per page? [10]: " n_queries
		if [ -z "$n_queries" ] ; then
			n_queries=10; break;
		fi
		if [[ $n_queries =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done

	read -p "Do you wish to set on or off the terminal agent listener? [on]: " backgr_listener
	if [ -z "$backgr_listener" ] ; then
		backgr_listener=on;
	fi

	if [ "$backgr_listener" == "on" ] ; then
		while true; do
			read -p "At which local port should it be listening? [6666]: " local_port
			if [ -z "$local_port" ] ; then
				local_port=6666; break;
			fi
			if [[ $local_port =~ $re ]] ; then
				break;
			fi
			echo "Please write a number or leave in blank for default value."
			echo ""
		done
	else
		local_port=6666
	fi
		
	while true; do
		read -p "To which port should the server connect to in the terminals? [5555]: " remote_port
		if [ -z "$remote_port" ] ; then
			remote_port=5555; break;
		fi
		if [[ $remote_port =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done
		
	while true; do
		read -p "How much time should the socket connections have as timeout in seconds? [90]: " timeout
		if [ -z "$timeout" ] ; then
			timeout=90; break;
		fi
		if [[ $timeout =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done
		
	read -p "What should be the ack message for the agent? [REQUEST RECEIVED]: " ok_msg
	if [ -z "$ok_msg" ] ; then
		ok_msg="REQUEST RECEIVED";
	fi
		
	while true; do
		read -p "Which should be the maximum number of parallel threads for updating terminals' data? [20]: " max_threads
		if [ -z "$max_threads" ] ; then
			max_threads=20; break;
		fi
		if [[ $max_threads =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done
		
	while true; do
		read -p "Which should be the desirable maximum number of terminals to update per thread? [50]: " max_terminals_thread
		if [ -z "$max_terminals_thread" ] ; then
			max_terminals_thread=50; break;
		fi
		if [[ $max_terminals_thread =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done
		
	while true; do
		read -p "How much time in seconds should be allow each thread to last before considering it problematic? [1200]: " max_time_thread
		if [ -z "$max_time_thread" ] ; then
			max_time_thread=1200; break;
		fi
		if [[ $max_time_thread =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done

	# We replace the original values with the provided ones
	sed --in-place "s/^config\.terminalsPageSize=.*\$/config.terminalsPageSize=$n_terminals/g;" $config_file

	sed --in-place "s/^config\.usersPageSize=.*\$/config.usersPageSize=$n_users/g;" $config_file

	sed --in-place "s/^config\.rolesPageSize=.*\$/config.rolesPageSize=$n_roles/g;" $config_file

	sed --in-place "s/^config\.queriesPageSize=.*\$/config.queriesPageSize=$n_queries/g;" $config_file

	sed --in-place "s/^config\.backgroundListener=.*\$/config.backgroundListener=$backgr_listener/g;" $config_file

	sed --in-place "s/^config\.serverSocketPort=.*\$/config.serverSocketPort=$local_port/g;" $config_file

	sed --in-place "s/^config\.agentSocketPort=.*\$/config.agentSocketPort=$remote_port/g;" $config_file

	sed --in-place "s/^config\.socketTimeOut=.*\$/config.socketTimeOut=$timeout/g;" $config_file

	sed --in-place "s/^config\.agentOkMessage=.*\$/config.agentOkMessage=$ok_msg/g;" $config_file

	sed --in-place "s/^config\.maxNumberUpdateThreads=.*\$/config.maxNumberUpdateThreads=$max_threads/g;" $config_file

	sed --in-place "s/^config\.maxNumberTerminalsPerThread=.*\$/config.maxNumberTerminalsPerThread=$max_terminals_thread/g;" $config_file

	sed --in-place "s/^config\.maxTimeRequestThread=.*\$/config.maxTimeRequestThread=$max_time_thread/g;" $config_file

fi



# Afterwards we check the ATMMonitoring security parameters
echo ""
while true; do
    read -p "Do you wish to change ATMMonitoring's default permission schema? It is discouraged to do so if you have no knowledge about Java authorities. " yn
    case $yn in
        [Yy]es ) break;;
        [Nn]o ) break;;
        * ) echo "Please answer yes or no.";;
    esac
done

if [ "$yn" == "Yes" ] || [ "$yn" == "yes" ]; then

	echo "While configuring the permissions remember we define Java authorities for Spring, which means you must write each of them between single quotes (e.g. \"'ROLE_ADMIN'\"), and if you want to specify more than one for any parameter, use commas between them (e.g. \"'ROLE_ADMIN','ROLE_GUEST'\")"
	echo ""
	
	read -p "Which authorities should have access to help? ['CAN_ACCESS_HELP']: " help_access
	if [ -z "$help_access" ] ; then
		help_access="'CAN_ACCESS_HELP'";
	fi
		
	read -p "Which authorities should have access to user management? ['USER_MANAGER']: " user_access
	if [ -z "$user_access" ] ; then
		user_access="'USER_MANAGER'";
	fi
		
	read -p "Which authorities should have access to the dashboard? ['CAN_ACCESS_DASHBOARD']: " dashboard_access
	if [ -z "$dashboard_access" ] ; then
		dashboard_access="'CAN_ACCESS_DASHBOARD'";
	fi
		
	read -p "Which authorities should be allowed to schedule updates? ['CAN_SCHEDULE']: " can_schedule
	if [ -z "$can_schedule" ] ; then
		can_schedule="'CAN_SCHEDULE'";
	fi
		
	read -p "Which authorities should have access to the terminals' data? ['CAN_VIEW_TERMINALS']: " terminals_access
	if [ -z "$terminals_access" ] ; then
		terminals_access="'CAN_VIEW_TERMINALS'";
	fi
		
	read -p "Which authorities should be allowed to edit the terminals' data? ['CAN_EDIT_TERMINALS']: " can_edit_terminals
	if [ -z "$can_edit_terminals" ] ; then
		can_edit_terminals="'CAN_EDIT_TERMINALS'";
	fi
		
	read -p "Which authorities should be allowed to request terminals' data updates? ['CAN_REQUEST_UPDATE']: " can_request_update
	if [ -z "$can_request_update" ] ; then
		can_request_update="'CAN_REQUEST_UPDATE'";
	fi
		
	read -p "Which authorities should be allowed to query the terminals' data? ['CAN_USE_QUERIES']: " queries_access
	if [ -z "$queries_access" ] ; then
		queries_access="'CAN_USE_QUERIES'";
	fi
		
	read -p "Which authorities should be allowed to access the reports? ['CAN_ACCESS_REPORTS']: " reports_access
	if [ -z "$reports_access" ] ; then
		reports_access="'CAN_ACCESS_REPORTS'";
	fi
		
	read -p "Which authorities should be allowed to edit widgets' libraries? ['CAN_EDIT_WIDGETS_LIBRARY']: " can_edit_widgets_libs
	if [ -z "$can_edit_widgets_libs" ] ; then
		can_edit_widgets_libs="'CAN_EDIT_WIDGETS_LIBRARY'";
	fi

	# We replace the original values with the provided ones
	sed --in-place "s/^security\.helpAccessAllowedRoles=.*\$/security.helpAccessAllowedRoles=$help_access/g;" $config_file

	sed --in-place "s/^security\.usersAccessAllowedRoles=.*\$/security.usersAccessAllowedRoles=$user_access/g;" $config_file

	sed --in-place "s/^security\.dashboardAccessAllowedRoles=.*\$/security.dashboardAccessAllowedRoles=$dashboard_access/g;" $config_file

	sed --in-place "s/^security\.schedulesAccessAllowedRoles=.*\$/security.schedulesAccessAllowedRoles=$can_schedule/g;" $config_file

	sed --in-place "s/^security\.terminalsAccessAllowedRoles=.*\$/security.terminalsAccessAllowedRoles=$terminals_access/g;" $config_file

	sed --in-place "s/^security\.terminalsManagementAllowedRoles=.*\$/security.terminalsManagementAllowedRoles=$can_edit_terminals/g;" $config_file

	sed --in-place "s/^security\.terminalsUpdateRequestAllowedRoles=.*\$/security.terminalsUpdateRequestAllowedRoles=$can_request_update/g;" $config_file

	sed --in-place "s/^security\.queriesAccessAllowedRoles=.*\$/security.queriesAccessAllowedRoles=$queries_access/g;" $config_file

	sed --in-place "s/^security\.reportsAccessAllowedRoles=.*\$/security.reportsAccessAllowedRoles=$reports_access/g;" $config_file

	sed --in-place "s/^security\.editWidgetsLibraryAllowedRoles=.*\$/security.editWidgetsLibraryAllowedRoles=$can_edit_widgets_libs/g;" $config_file

fi



# Last of all, the database connection parameters
echo ""
while true; do
    read -p "Do you wish to specify the database connection parameters? " yn
    case $yn in
        [Yy]es ) break;;
        [Nn]o ) break;;
        * ) echo "Please answer yes or no.";;
    esac
done

if [ "$yn" == "Yes" ] || [ "$yn" == "yes" ]; then

	read -p "What will be the IP for connecting to the database? [localhost]: " db_ip
	if [ -z "$db_ip" ] ; then
		db_ip="localhost";
	fi
		
	while true; do
		read -p "What will be the port for connecting to the database? [5432]: " db_port
		if [ -z "$db_port" ] ; then
			db_port=5432; break;
		fi
		if [[ $db_port =~ $re ]] ; then
			break;
		fi
		echo "Please write a number or leave in blank for default value."
		echo ""
	done
		
	read -p "What will be the username for connecting to the database? [postgres]: " db_user
	if [ -z "$db_user" ] ; then
		db_user="postgres";
	fi
		
	read -p "What will be the password for connecting to the database? [postgres]: " db_pass
	if [ -z "$db_pass" ] ; then
		db_pass="postgres";
	fi
		
	read -p "What will be the database name? [atm-monitoring]: " db_name
	if [ -z "$db_name" ] ; then
		db_name="atm-monitoring";
	fi

	# We replace the original values with the provided ones
	sed --in-place "s/^jdbc\.databaseurl=.*\$/jdbc.databaseurl=jdbc\\:postgresql\\:\/\/$db_ip\\:$db_port\/$db_name/g;" $db_file

	sed --in-place "s/^jdbc\.username=.*\$/jdbc.username=$db_user/g;" $db_file

	sed --in-place "s/^jdbc\.password=.*\$/jdbc.password=$db_pass/g;" $db_file

fi

# We rename the original .war file, just in case any error happens before the script ends
mv ../$file ../$file.tmp
# We pack the contents again
jar -cf ../$file .
cd ..
# Delete the temp folder
rm -rf .ATM_temp

# If the new .war file looks okay, then we can delete the temporary copy we had previously created
if [ -w $file ]; then
	rm $file.tmp
fi

echo ""
echo "Parameters successfully configured! You can now deploy the .war file."

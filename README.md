# Assignment14
Once this project is imported and running in your IDE, the endpoint /welcome will allow you to create a user. From there, you will be redirected to the dashboard.
Within the dashboard, a user can select an already created channel to join. On boot, a general channel will be created for all users to access.
To create a new channel, enter the endpoint "/channel/{channelName}". 
To access a created channel, you can either use the dashboard, or use the channel Id of your desired endpoint in your URL to reach said channel. 
As an example, the general channel will default to channel Id 1. If you created a second channel, you would reach said channel through the endpoint, "/channels/2".
Please note that when creating a new channel, the endpoint URL is channel, not channels.

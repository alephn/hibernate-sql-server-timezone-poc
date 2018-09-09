 CREATE TABLE [dbo].[calls](
	[fromNumber] [nvarchar](12) NOT NULL,
	[toNumber] [nvarchar](12) NOT NULL,
	[timestamp] [datetimeoffset](7) NOT NULL,
	[id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
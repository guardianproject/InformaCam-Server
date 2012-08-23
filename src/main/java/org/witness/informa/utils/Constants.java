package org.witness.informa.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface Constants {
	public final static String LOG = "***** InformaCamServer: ";
	public final static String WEB_ROOT = LocalConstants.WEB_ROOT;
	public final static String APP_ROOT = WEB_ROOT + "InformaCam-Server/";
	public final static String MEDIA_CACHE = APP_ROOT + "src/main/webapp/images/session_cache/";
	public final static String VIEW_ROOT = APP_ROOT + "view_templates/";
	public final static String VIEW_CACHE = VIEW_ROOT + "caches/";
	
	public final static class Couch {
		public static String ERROR = "COUCH ERROR";
		public static String INFO = "COUCH INFO";
		public static String DEBUG = "COUCH DEBUG";
		public final static String VAR_SENTINEL = "@VARS";
		
		public final static class Documents {
			public final static String _ID = "_id";
			public final static String _REV = "_rev";
		}
		
		public final static class Views {
			public final static class Submissions {
				public final static String GET_BY_HASHED_PGP = "hashed_pgp";
				public final static String GET_BY_MEDIA_TYPE = "media_type";
				public final static class GetByTimestamp {
					public final static String RECEIVED = "timestamp_received";
					public final static String SUBMITTED = "timestamp_submitted";
					public final static String CREATED = "timestamp_created";
				}
			}
			
			public final static class Sources {
				
			}
			
			public final static class Derivatives {
				public final static class Geolocate {
					public final static String RADIUS = "radius";
					public final static String QUERY_LAT = "queryLat";
					public final static String QUERY_LNG = "queryLng";
				}
				
				public final static String GET_ALL = "name";
				
			}
			
			public final static class TempViews {
				public final static String GEOLOCATE = VIEW_ROOT + "geolocate.json";
			}
		}
		
	}
	
	public final static class DC {
		public final static String RESPONSE = "response";
		
		public final static class Attempts {
			public final static String TAG = "attempt";
			public final static int CHOOSE_MEDIA = 99;
			public final static int LOAD_MEDIA = 100;
			public final static int VIEW_SUBMISSIONS = 102;
			public final static int SEARCH = 103;
		}
		
		public final static class Commands {
			public final static int CHOOSE_MEDIA = DC.Attempts.CHOOSE_MEDIA;
			public final static int LOAD_MEDIA = DC.Attempts.LOAD_MEDIA;
			public final static int WAIT_FOR_PROCESS = 101;
			public final static int VIEW_SUBMISSIONS = DC.Attempts.VIEW_SUBMISSIONS;
			public final static int LOAD_SEARCH_RESULTS = DC.Attempts.SEARCH;
		}
		
		public final static class Keys {
			public final static String COMMAND = "command";
			public final static String MEDIA_TYPE = "mediaType";
			public final static String METADATA = "metadata";
			public final static String INTERRUPT = "interrupt";
			public final static String WAIT_CODE = "waitCode";
			public final static String MESSAGE = "message";
			public final static String OPTIONS = "options";
		}
		
		public final static class Options {
			public final static String _ID = Couch.Documents._ID;
			public final static String _REV = Couch.Documents._REV;
			public final static String LOCAL_MEDIA_PATH = "attachment";
		}
		
	}
	
	public final static class Callback {
		public final static class Jpeg {
			public final static String GET_METADATA = "getMetadata";
			public final static String REVERSE_REDACTION = "reverseRedaction";
			
		}
		
		public final static class Ffmpeg {
			
		}
	}
	
	public final static class UI {
		public final static class Prompt {
			public final static String MEDIA_PICKER = "Jpeg or Movie";
			public final static String MEDIA_LOADING = "Media Loading";
		}
	}
	
	public final static class Search {
		public final static class Parameters {
			public final static Map<String, Integer> KEYS;
			static {
				Map<String, Integer> keys = new HashMap<String, Integer>();
				keys.put(Search.Parameters.Keywords.TAG, Search.Parameters.Keywords.KEY);
				keys.put(Search.Parameters.Type.TAG, Search.Parameters.Type.KEY);
				keys.put(Search.Parameters.Timeframe.TAG, Search.Parameters.Timeframe.KEY);
				keys.put(Search.Parameters.Location.TAG, Search.Parameters.Location.KEY);
				KEYS = Collections.unmodifiableMap(keys);
			}
			
			public final static class Keywords {
				public final static String TAG = "keyword";
				public final static int KEY = 299;
			}
			
			public final static class Type {
				public final static int KEY = 298;
				public final static String TAG = "type";
				
				public final static int IMAGE = Media.MediaTypes.IMAGE;
				public final static int VIDEO = Media.MediaTypes.VIDEO;
				public final static Map<String, Integer> TYPES;
				static {
					Map<String, Integer> types = new HashMap<String, Integer>();
					types.put("IMAGE", Search.Parameters.Type.IMAGE);
					types.put("VIDEO", Search.Parameters.Type.VIDEO);
					TYPES = Collections.unmodifiableMap(types);
				}
			}
			
			public final static class Timeframe {
				public final static int KEY = 297;
				public final static String TAG = "timeframe";
				
				public final static int PAST_24_HOURS = 300;
				public final static int PAST_WEEK = 301;
				public final static int PAST_MONTH = 302;
				public final static int PAST_YEAR = 303;
				public final static int CUSTOM_RANGE = 304;
				public final static Map<String, Integer> TIMEFRAMES;
				static {
					Map<String, Integer> timeframes = new HashMap<String, Integer>();
					timeframes.put("PAST_24_HOURS", Search.Parameters.Timeframe.PAST_24_HOURS);
					timeframes.put("PAST_WEEK", Search.Parameters.Timeframe.PAST_WEEK);
					timeframes.put("PAST_MONTH", Search.Parameters.Timeframe.PAST_MONTH);
					timeframes.put("PAST_YEAR", Search.Parameters.Timeframe.PAST_YEAR);
					timeframes.put("CUSTOM_RANGE", Search.Parameters.Timeframe.CUSTOM_RANGE);
					TIMEFRAMES = Collections.unmodifiableMap(timeframes);
				}
			}
			
			public final static class Location {
				public final static int KEY = 296;
				public final static String TAG = "location";
				
				public final static int RADIUS = 305;
				public final static int LATLNG = 306;
				public final static Map<String, Integer> LOCATION_PARAMETERS;
				static {
					Map<String, Integer> location_parameters = new HashMap<String, Integer>();
					location_parameters.put("RADIUS", Search.Parameters.Location.RADIUS);
					location_parameters.put("LATLNG", Search.Parameters.Location.LATLNG);
					LOCATION_PARAMETERS = Collections.unmodifiableMap(location_parameters);
				}
			}
		}
		
	}
	
	public final static class Media {
		public final static String LOCAL_PATH = "localPath";
		
		public final static String[] EXTENSIONS = {"jpeg", "jpg", "mov", "mp4", "mkv", "ogg"};
		public final static class MimeTypes {
			public final static int JPEG = 100;
			public final static int MP4 = 101;
			public final static int MOV = 102;
			public final static int MKV = 103;
			public final static int OGG = 104;
		}
		public final static Map<String, Integer> MIME_TYPES;
		static {
			Map<String, Integer> mime_types = new HashMap<String, Integer>();
			mime_types.put(".jpeg", Media.MimeTypes.JPEG);
			mime_types.put(".jpg", Media.MimeTypes.JPEG);
			mime_types.put(".mov", Media.MimeTypes.MOV);
			mime_types.put(".mp4", Media.MimeTypes.MP4);
			mime_types.put(".mkv", Media.MimeTypes.MKV);
			mime_types.put(".ogg", Media.MimeTypes.OGG);
			MIME_TYPES = Collections.unmodifiableMap(mime_types);
		}
		
		public final static String MEDIA_TYPE = "mediaType";
		public final static class MediaTypes {
			public final static int VIDEO = 401;
			public final static int IMAGE = 400;
		}
		
		public final static String DIMENSIONS = "dimensions";
		public final static class Dimensions {
			public final static String WIDTH = "width";
			public final static String HEIGHT = "height";
		}
		
		public final static String PATH = "filePath";
	}
	
	public final static class Ffmpeg {
		public final static String ROOT = "/usr/local/bin/";
		public final static String PID = "processId";
		
		public final static String CLONE = "%vpathclone_%vroot.mp4";
		public final static String METADATA = "%vpathinforma_metadata_%vroot.txt";
		
		public final static String CHECK = Ffmpeg.ROOT + "ffmpeg";
		public final static String GET_INFO = Ffmpeg.ROOT + "ffmpeg -i %vid";
		public final static String SHOW_STREAMS = Ffmpeg.ROOT + "ffprobe -pretty -show_streams %vid";
		public final static String EXTRACT_INFORMA_TRACK = Ffmpeg.ROOT + "ffmpeg -y -i %vid -an -vn -sbsf mov2textsub -scodec copy -f rawvideo %metadata";
		public final static String EMBED_INFORMA_TRACK = Ffmpeg.ROOT + "ffmpeg -y -i %vid -i %inft -scodec copy -vcodec copy -acodec copy %vpath%vroot.mkv";
		public final static String CLONE_FROM_MKV = Ffmpeg.ROOT + "ffmpeg -y -i %vid -vcodec copy -acodec copy %clone";
		
		public final static class Replace {
			public final static String VIDEO = "%vid";
			public final static String VIDEO_ROOT = "%vroot";
			public final static String VIDEO_PATH = "%vpath";
			public final static String CLONE = "%clone";
			public final static String METADATA = "%metadata";
		}
		
		public final static Map<String, String> TAGS;
		static {
			Map<String, String> tags = new HashMap<String, String>();
			tags.put("[STREAM]", "stream");
			TAGS = Collections.unmodifiableMap(tags);
		}
		
		public final static class Tags {
			public final static String END = "[/%tag]";
			public final static String RETURN = "result";
			public final static String TYPE = "type";
			
			public final static class Stream {
				public final static String CODEC_NAME = "codec_name";
				public final static String CODEC_TYPE = "codec_type";
				public final static String CODEC_TIME_BASE = "codec_time_base";
				public final static String CODEC_R_FRAME_RATE = "r_frame_rate";
				public final static String CODEC_AVG_FRAME_RATE = "avg_frame_rate";
				public final static String CODEC_NB_FRAMES = "nb_frames";
				public final static String CODEC_DURATION = "duration";
				public final static String CODEC_INDEX = "index";
				public final static String CODEC_WIDTH = "width";
				public final static String CODEC_HEIGHT = "height";
			}
		}
	}
}

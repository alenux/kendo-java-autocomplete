<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kendo UI AutoComplete Demo</title>

    <link rel="stylesheet" href="http://cdn.kendostatic.com/2013.2.716/styles/kendo.common.min.css">
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2013.2.716/styles/kendo.default.min.css">
    <link rel="stylesheet" href="/App/style.css">
    
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://cdn.kendostatic.com/2013.2.716/js/kendo.all.min.js"></script>
</head>
<body>
    <div>
        <label for="country">Country:</label>
        <kendo:autoComplete name="country" id="country">
            <kendo:dataSource>
                <kendo:dataSource-transport read="/App/countries"/>
            </kendo:dataSource>
        </kendo:autoComplete>
    </div>
    
    <div>
        <label for="site">Domain:</label>
        <kendo:autoComplete name="site" id="site">
            <kendo:dataSource serverFiltering="true">
                <kendo:dataSource-transport read="/App/sites">
                    <kendo:dataSource-transport-parameterMap>
                        function( options ) {
                            return { filter: options.filter.filters[ 0 ].value };
                        }
                    </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
            </kendo:dataSource>
        </kendo:autoComplete>
    </div>
</body>
</html>

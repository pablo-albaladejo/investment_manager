-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 21-07-2014 a las 23:08:33
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `investment_manager`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `asset`
-- 

CREATE TABLE `asset` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `ranking` int(11) NOT NULL,
  `stock_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_2llxra3tou2wqif8tliktwm1o` (`company_id`),
  KEY `FK_t7cxw57wmi4te2v9jfelrk3nn` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `asset`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `bond`
-- 

CREATE TABLE `bond` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `days` int(11) NOT NULL,
  `interest` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `bond`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `company`
-- 

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `marketcap` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `symbol` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `company`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `email`
-- 

CREATE TABLE `email` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `email`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `forecast`
-- 

CREATE TABLE `forecast` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `asset_id` bigint(20) NOT NULL,
  `ranking` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_peqk8fpo8mabryagqkq6xnxvh` (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `forecast`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `forecast_investment`
-- 

CREATE TABLE `forecast_investment` (
  `forecast_investments_id` bigint(20) default NULL,
  `investment_id` bigint(20) default NULL,
  KEY `FK_d5gkuo2qxb84sgbioh1yv6oy3` (`investment_id`),
  KEY `FK_egmf95h2ih4ijysxllsfeblb7` (`forecast_investments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `forecast_investment`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `investment`
-- 

CREATE TABLE `investment` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `days` int(11) NOT NULL,
  `interest` float NOT NULL,
  `principal` float NOT NULL,
  `ranking` int(11) NOT NULL,
  `rate` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `investment`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `overall_report`
-- 

CREATE TABLE `overall_report` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `summary_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_gisvf62rtccxilmta4cvh2o2p` (`summary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `overall_report`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `overall_report_asset`
-- 

CREATE TABLE `overall_report_asset` (
  `overall_report_assets_id` bigint(20) default NULL,
  `asset_id` bigint(20) default NULL,
  KEY `FK_9wdlg5trf6knjy2qoe8rsrigf` (`asset_id`),
  KEY `FK_arqrm6753k8dcdx39t7rrxgrc` (`overall_report_assets_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `overall_report_asset`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `overall_report_forecast`
-- 

CREATE TABLE `overall_report_forecast` (
  `overall_report_forecasts_id` bigint(20) default NULL,
  `forecast_id` bigint(20) default NULL,
  KEY `FK_ou1r1yvve4v9t7f6asj3voqjp` (`forecast_id`),
  KEY `FK_105y8i3hbwb3oo0d6ocockcv2` (`overall_report_forecasts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `overall_report_forecast`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `stock`
-- 

CREATE TABLE `stock` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `beta` float NOT NULL,
  `capm` float NOT NULL,
  `marketprice` float NOT NULL,
  `pricechange` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `stock`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `summary`
-- 

CREATE TABLE `summary` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `market_return` float NOT NULL,
  `risk_free` float NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `summary`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `treasury_bonds`
-- 

CREATE TABLE `treasury_bonds` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `treasury_bonds`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `treasury_bonds_bond`
-- 

CREATE TABLE `treasury_bonds_bond` (
  `treasury_bonds_bonds_id` bigint(20) default NULL,
  `bond_id` bigint(20) default NULL,
  KEY `FK_ga59jfblcwi3a5fwa95wgoxws` (`bond_id`),
  KEY `FK_tpouw33bl0j2sdxassjb8fvq1` (`treasury_bonds_bonds_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `treasury_bonds_bond`
-- 


-- 
-- Filtros para las tablas descargadas (dump)
-- 

-- 
-- Filtros para la tabla `asset`
-- 
ALTER TABLE `asset`
  ADD CONSTRAINT `FK_t7cxw57wmi4te2v9jfelrk3nn` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`),
  ADD CONSTRAINT `FK_2llxra3tou2wqif8tliktwm1o` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

-- 
-- Filtros para la tabla `forecast`
-- 
ALTER TABLE `forecast`
  ADD CONSTRAINT `FK_peqk8fpo8mabryagqkq6xnxvh` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`id`);

-- 
-- Filtros para la tabla `forecast_investment`
-- 
ALTER TABLE `forecast_investment`
  ADD CONSTRAINT `FK_egmf95h2ih4ijysxllsfeblb7` FOREIGN KEY (`forecast_investments_id`) REFERENCES `forecast` (`id`),
  ADD CONSTRAINT `FK_d5gkuo2qxb84sgbioh1yv6oy3` FOREIGN KEY (`investment_id`) REFERENCES `investment` (`id`);

-- 
-- Filtros para la tabla `overall_report`
-- 
ALTER TABLE `overall_report`
  ADD CONSTRAINT `FK_gisvf62rtccxilmta4cvh2o2p` FOREIGN KEY (`summary_id`) REFERENCES `summary` (`id`);

-- 
-- Filtros para la tabla `overall_report_asset`
-- 
ALTER TABLE `overall_report_asset`
  ADD CONSTRAINT `FK_arqrm6753k8dcdx39t7rrxgrc` FOREIGN KEY (`overall_report_assets_id`) REFERENCES `overall_report` (`id`),
  ADD CONSTRAINT `FK_9wdlg5trf6knjy2qoe8rsrigf` FOREIGN KEY (`asset_id`) REFERENCES `asset` (`id`);

-- 
-- Filtros para la tabla `overall_report_forecast`
-- 
ALTER TABLE `overall_report_forecast`
  ADD CONSTRAINT `FK_105y8i3hbwb3oo0d6ocockcv2` FOREIGN KEY (`overall_report_forecasts_id`) REFERENCES `overall_report` (`id`),
  ADD CONSTRAINT `FK_ou1r1yvve4v9t7f6asj3voqjp` FOREIGN KEY (`forecast_id`) REFERENCES `forecast` (`id`);

-- 
-- Filtros para la tabla `treasury_bonds_bond`
-- 
ALTER TABLE `treasury_bonds_bond`
  ADD CONSTRAINT `FK_tpouw33bl0j2sdxassjb8fvq1` FOREIGN KEY (`treasury_bonds_bonds_id`) REFERENCES `treasury_bonds` (`id`),
  ADD CONSTRAINT `FK_ga59jfblcwi3a5fwa95wgoxws` FOREIGN KEY (`bond_id`) REFERENCES `bond` (`id`);
